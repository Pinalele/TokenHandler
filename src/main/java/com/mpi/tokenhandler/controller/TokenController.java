package com.mpi.tokenhandler.controller;

import com.mpi.tokenhandler.model.Token;
import com.mpi.tokenhandler.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/generate")
    public Token generateToken(){
         return tokenService.storeToken();
    }


}
