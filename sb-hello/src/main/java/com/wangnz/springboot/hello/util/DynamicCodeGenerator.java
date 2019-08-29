package com.wangnz.springboot.hello.util;

/**
 * 动态码生成器.
 *
 * @author nanzhi wang
 * @since 20170310
 */
public class DynamicCodeGenerator {
    private final static String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private final static String[] numAndLetter = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String generateNum(int length) {
        String code = "";
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * 10);
            code += num[rand];
        }
        return code;
    }

    public static String generateWord(int length) {
        String code = "";
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * 62);
            code += numAndLetter[rand];
        }
        return code;
    }

    public static void main(String[] args) {
        System.out.println(DynamicCodeGenerator.generateWord(3));
    }
}
