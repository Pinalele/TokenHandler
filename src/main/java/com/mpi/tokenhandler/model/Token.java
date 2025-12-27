package com.mpi.tokenhandler.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String token;
    @Column
    private LocalDateTime createTime;
    @Column
    private String userLogin;

    public Token(String token, LocalDateTime createTime, String user) {
        this.token = token;
        this.createTime = createTime;
        this.userLogin = user;
    }
}
