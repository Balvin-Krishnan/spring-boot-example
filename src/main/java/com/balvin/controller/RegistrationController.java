package com.balvin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balvin.dto.User;

@RestController
public class RegistrationController {
 
    @RequestMapping(//method = RequestMethod.GET,
                    value = "/register",
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> register() {
    	User user = new User();
    	user.setAddress("asbd");
    	user.setName("Balvin");
    	user.setLastName("Krish");
        
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
     
    @ExceptionHandler
    void handleIllegalArgumentException(
                      IllegalArgumentException e,
                      HttpServletResponse response) throws IOException {
 
        response.sendError(HttpStatus.BAD_REQUEST.value());
 
    }
}