package com.misshhok.restapi.controller;

import com.misshhok.restapi.entity.UserEntity;
import com.misshhok.restapi.exceptions.UserAlreadyExistsException;
import com.misshhok.restapi.exceptions.UserNotFoundException;
import com.misshhok.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registartion(@RequestBody UserEntity user) {
        try {
            userService.registartion(user);
            return ResponseEntity.ok().body("User successfully created");
        }
        catch (UserAlreadyExistsException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Something was wrong");
        }
    }



    @GetMapping()
    public ResponseEntity getOne(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        }
        catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Something was wrong");
        }
    }


    @DeleteMapping("{id}/")
    public ResponseEntity delUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(userService.deleteUser(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Something was wrong");
        }
    }

}
