/*
 * Copyright © FieldCircle. All rights Reserved. by Jovanta Consultants Private Limited.
 *
 * Created by Md Faizan
 */
package com.suhail.shopping.common.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * This JwtUtil provide functionality to create a JSON web token by username
 * This class also provides some other functionality
 */
@Component
public class JwtUtil {

    // secret key which is used to encode or decode token.
    private String secret = SecurityConstants.KEY;


    public Long extractId(String token) {
        return Long.parseLong(extractClaim(token, Claims::getId));
    }

    /**
     * Function to get the username from token
     * @param token
     * @return claim (Username)
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    /**
     * Function to get expiration date of that token
     * @param token
     * @return Expiration time
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * Function to check whether the token is expired or not
     * @param token
     * @return true if token not expired
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * This method generate token by username
     * @param username
     * @return token
     */
    public String generateToken(Long id, String username, Map<String, Object> claims) {
        return createToken(String.valueOf(id), username, claims);
    }


    private String createToken(String id, String subject, Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setId(id).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, secret).setHeader(
                        (Map<String, Object>) Jwts.header().setType(Header.JWT_TYPE)
                ).compact();
    }

}

