package com.mpi.tokenhandler.repository;

import com.mpi.tokenhandler.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Modifying
    @Query("DELETE FROM Token e WHERE e.createTime < :cutoffDate")
    int deleteByCreatedDateBefore(LocalDateTime cutoffDate);
}
