package com.jesse.spring.util;

import java.util.Random;

public class VerificationCodeUtils {
    private static String[] code = {
            "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y",
            "z", "A", "B", "C", "D",
            "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X",
            "Y", "Z", "0", "1", "2",
            "3", "4", "5", "6", "7",
            "8", "9"
    };

    public static String createVerificationCode(){
        String verificationCode = "";
        int length = code.length;
        for (int i = 0; i < 4; i++) {
            int randomInt = createRandomInt(length);
            verificationCode += getCode(randomInt);
        }
        return verificationCode;
    }


    public static int createRandomInt(int length){
        Random random = new Random();
        return random.nextInt(length);
    }

    public static String getCode(int position){
        if (code == null){
            return "";
        }
        if (position >= code.length){
            return "";
        }
        return code[position];
    }
}
