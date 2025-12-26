package com.mpi.tokenhandler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private LocalDate createTime;
    private String user;

    public Token(String token, LocalDate createTime, String user) {
        this.token = token;
        this.createTime = createTime;
        this.user = user;
    }
}
