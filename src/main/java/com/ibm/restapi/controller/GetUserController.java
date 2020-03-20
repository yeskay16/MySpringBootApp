package com.ibm.restapi.controller;

import com.ibm.restapi.exception.NotFoundException;
import com.ibm.restapi.model.User;
import com.ibm.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GetUserController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/users/{id}/userinfo")
    public ResponseEntity<Object> getUserInfo(@PathVariable int id) {
        User user = userService.getUserFromListOrDb(id);
        if (null == user) {
            throw new NotFoundException("User not found");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUsed = userService.createUser(user);
        return new ResponseEntity(savedUsed, HttpStatus.OK);

        }

}
