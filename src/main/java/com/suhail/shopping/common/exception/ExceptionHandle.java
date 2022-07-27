/*
 *
 *  *
 *  * Created by Suhail Khan
 *  *
 *
 */

package com.suhail.shopping.common.exception;

import com.suhail.shopping.common.rdo.BaseRdo;
import com.suhail.shopping.common.rdo.MyErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

/**
 * Custom Exception Handler for RunTimeException
 * occur then this exception handle
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> exception(InvalidTokenException exc) {
        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.UNAUTHORIZED.value());

        // create response
        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
        responseEntity.setData(errorResponse);
        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(responseEntity, HttpStatus.UNAUTHORIZED);
    }

    /**
     * handle PermissionDeniedException
     * @param exc
     * @return response of ErrorResponse
     */
    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> exception(PermissionDeniedException exc) {
        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.UNAUTHORIZED.value());

        // create response
        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
        responseEntity.setData(errorResponse);
        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(responseEntity, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> exception(BadRequestException exc) {
        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST.value());

        // create response
        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
        responseEntity.setData(errorResponse);
        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> exception(InvalidUserNameException exc) {
        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST.value());

        // create response
        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
        responseEntity.setData(errorResponse);
        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(responseEntity,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<MyErrorResponse> exception(InvalidPasswordException exc){
        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.BAD_REQUEST.value());

        // create response
        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
        responseEntity.setData(errorResponse);
        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(responseEntity, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler
//    public ResponseEntity<MyErrorResponse> exception(Exception exc) {
//        MyErrorResponse errorResponse = new MyErrorResponse(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
//
//        // create response
//        BaseRdo<MyErrorResponse> responseEntity = new BaseRdo<>();
//        responseEntity.setData(errorResponse);
//        responseEntity.setDate(new Timestamp(System.currentTimeMillis()));
//        return new ResponseEntity(responseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
