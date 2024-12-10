package com.home.serviceshuffle.service;

import com.home.serviceshuffle.model.LogRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Service
public class ShuffleService {

    @Value("${service-log.base-url}")
    private String logServiceUrl;

    private final WebClient webClient = WebClient.create();

    public int[] shuffleArray(int number) {
        int[] array = IntStream.rangeClosed(1, number).toArray();
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = ThreadLocalRandom.current().nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }

    public void sendLogRequest(int number, int[] shuffledArray) {
        webClient.post()
                .uri(logServiceUrl)
                .bodyValue(new LogRequest(number, shuffledArray))
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
