package com.doorstep.api.controllers;

import com.doorstep.api.models.AuthRequest;
import com.doorstep.api.models.User;
import com.doorstep.api.service.JwtService;
import com.doorstep.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {

         Authentication authentication = authenticationManager.authenticate(
                         new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

         if (authentication.isAuthenticated()){
             return jwtService.generateToken(authRequest.getUsername());
         }
         else {
             return "Something wrong";
         }
    }

    @GetMapping("/protected")
    public String test(){
        return "Endpoint working";
    }


}
