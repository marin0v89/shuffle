package com.home.servicelog.controller;

import com.home.servicelog.model.LogRequest;
import com.home.servicelog.service.LoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {

    private final LoggingService loggingService;

    public LogController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @PostMapping
    public ResponseEntity<Void> logRequest(@RequestBody LogRequest logRequest) {
        loggingService.logRequest(logRequest);
        return ResponseEntity.ok().build();
    }
}