package com.home.servicelog.controller;

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

    private static class LogRequest {
        private int number;
        private int[] result;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int[] getResult() {
            return result;
        }

        public void setResult(int[] result) {
            this.result = result;
        }
    }
}