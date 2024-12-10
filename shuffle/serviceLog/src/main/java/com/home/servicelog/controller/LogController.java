package com.home.servicelog.controller;

import com.home.servicelog.model.LogRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping
    public ResponseEntity<Void> logRequest(@RequestBody LogRequest logRequest) {
        logger.info("Received log request: number={}, result={}",
                logRequest.getNumber(), logRequest.getResult());
        return ResponseEntity.ok().build();
    }
}