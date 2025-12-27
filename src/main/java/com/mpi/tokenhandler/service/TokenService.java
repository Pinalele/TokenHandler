package com.mpi.tokenhandler.service;

import com.mpi.tokenhandler.model.Token;
import com.mpi.tokenhandler.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TokenService {


    private final TokenRepository tokenRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TOKEN_LENGTH = 12;
    private static final SecureRandom random = new SecureRandom();


    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token storeToken() {
        Token newToken = new Token(generateToken(), LocalDate.now(), "Dummy");
        return tokenRepository.save(newToken);
    }

    public static String generateToken() {
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(index));
        }

        return token.toString();
    }

    public List<Token> getAllTokens(){
        return tokenRepository.findAll();
    }
}
