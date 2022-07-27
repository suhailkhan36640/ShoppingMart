/*
 * Copyright © FieldCircle. All rights Reserved. by Jovanta Consultants Private Limited.
 *
 * Created by Md Faizan
 */
package com.suhail.shopping.common.util;

/**
 * here we declare some constant
 */
public class SecurityConstants {


    // this key is used for encode or decode the token
    public static final String KEY = "q3t6w9z$C&F)J@NcQfT4j5&5%$#@hhjWnZr4u7x!f44y/B?E(H+MbQeTh";

    // this header name is for token
    public static final String HEADER_NAME = "Authorization";

    // expiration time one day
    public static final Long EXPIRATION_TIME = 1000L*60*60*24;
}