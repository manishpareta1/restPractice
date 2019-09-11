package com.example.friends.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class FriendControllerAdvice {

    /**
     * This method is used to handle the exception generated by create() method.
     * @param ve
     * @return ErrorMessage
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    ErrorMessage exeptionHandler(ValidationException ve){
        return new ErrorMessage("400", ve.getMessage());
    }
}
