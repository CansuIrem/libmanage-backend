package com.example.LibManage;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ISBNGenerator {

    public String generateRandomIsbn13() {
        Random random = new Random();

        long isbn12 = random.nextLong() % 1_000_000_000_000L;
        isbn12 = Math.abs(isbn12);

        int checksum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = (int) (isbn12 % 10);
            isbn12 /= 10;
            checksum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checksumDigit = (10 - (checksum % 10)) % 10;
        return String.format("%012d%d", isbn12, checksumDigit);
    }
}

