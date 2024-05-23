package org.learning;

import java.util.*;

public class CharCounter {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);

        System.out.print("Write a word : ");
        String input = scann.nextLine();

        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        System.out.println(charCount);
        scann.close();
    }
}
