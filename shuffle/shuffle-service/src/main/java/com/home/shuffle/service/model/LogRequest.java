package com.home.shuffle.service.model;

public class LogRequest {

        private int number;
        private int[] result;

        public LogRequest(int number, int[] result) {
            this.number = number;
            this.result = result;
        }

        public int getNumber() {
            return number;
        }

        public int[] getResult() {
            return result;
        }
}
