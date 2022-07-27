/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.rdo;

import java.util.Date;

/**
 * Token Response data object
 */
public class TokenRdo {
    private String token;
    private Date expirationTime;

    public TokenRdo(){}
    public TokenRdo(String token, Date expirationTime) {
        this.token = token;
        this.expirationTime = expirationTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "TokenRdo{" +
                "token='" + token + '\'' +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
