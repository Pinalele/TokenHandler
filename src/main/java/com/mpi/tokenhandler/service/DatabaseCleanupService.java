package com.mpi.tokenhandler.service;

import com.mpi.tokenhandler.repository.TokenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class DatabaseCleanupService {

    private static final Logger log = LoggerFactory.getLogger(DatabaseCleanupService.class);
    private final TokenRepository tokenRepository;

    @Autowired
    public DatabaseCleanupService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Scheduled(cron = "0 */1 * * * ?")
    @Transactional
    public void cleanupOldRecords() {
        log.info("Start clean");
        LocalDateTime cutoffDate = LocalDateTime.now().minusHours(1);
        int deletedCount = tokenRepository.deleteByCreatedDateBefore(cutoffDate);
        log.info("Deleted {} old records", deletedCount);
    }
}
