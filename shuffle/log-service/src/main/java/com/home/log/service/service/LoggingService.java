package com.home.log.service.service;

import com.home.log.service.model.LogRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logRequest(LogRequest logRequest) {
        logger.info("Logging request: number={}, result={}", logRequest.getNumber(), logRequest.getResult());
    }
}
