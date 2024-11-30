/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_01;

/**
 *
 * @author canhduong
 */
public class RailFenceCipher {
    public static String encrypt(String text, int key) {
        if (key < 2) {
            return text; // No encryption needed if key is less than 2
        }

        char[] chars = text.toCharArray();
        char[] result = new char[chars.length];
        int cycle = 2 * (key - 1);
        int idx = 0;

        for (int i = 0; i < key; i++) {
            for (int j = i; j < chars.length; j += cycle) {
                result[idx++] = chars[j];
                if (i != 0 && i != key - 1 && j + cycle - 2 * i < chars.length) {
                    result[idx++] = chars[j + cycle - 2 * i];
                }
            }
        }

        return new String(result);
    }

    public static String decrypt(String text, int key) {
        if (key < 2) {
            return text; // No decryption needed if key is less than 2
        }

        char[] chars = text.toCharArray();
        char[] result = new char[chars.length];
        int cycle = 2 * (key - 1);
        int idx = 0;

        for (int i = 0; i < key; i++) {
            for (int j = i; j < result.length; j += cycle) {
                result[j] = chars[idx++];
                if (i != 0 && i != key - 1 && j + cycle - 2 * i < result.length) {
                    result[j + cycle - 2 * i] = chars[idx++];
                }
            }
        }

        return new String(result);
    }
}

