package com.home.shuffle.service.controller;

import com.home.shuffle.service.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shuffle")
public class ShuffleController {

    @Autowired
    private ShuffleService shuffleService;

    @PostMapping
    public ResponseEntity<int[]> shuffleNumbers(@RequestParam int number) {
        if (number < 1 || number > 1000) {
            return ResponseEntity.badRequest().body(null);
        }

        int[] result = shuffleService.shuffleArray(number);
        shuffleService.sendLogRequest(number, result);
        return ResponseEntity.ok(result);
    }
}
