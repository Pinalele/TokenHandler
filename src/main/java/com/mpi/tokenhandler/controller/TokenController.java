package com.mpi.tokenhandler.controller;

import com.mpi.tokenhandler.model.Token;
import com.mpi.tokenhandler.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/generate")
    public Token generateToken(){
         return tokenService.storeToken();
    }

    @GetMapping("/getAllTokens")
    public List<Token> tokenList(){
        return tokenService.getAllTokens();
    }


}
