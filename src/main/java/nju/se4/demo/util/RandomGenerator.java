package nju.se4.demo.util;


import java.util.Random;

public class RandomGenerator {
    public static String generateRandomCode() {
        String str = "";
        for(int i = 1; i <= 32; i++) {
            //bound must be positive
            Random random1 = new Random(i);
            str += random1.nextInt(i);
        }
        return str;
    }
}
