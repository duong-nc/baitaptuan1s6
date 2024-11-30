/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_01;

/**
 *
 * @author canhduong
 */
import java.util.Arrays;

public class TranspositionCipher {
    
    public String encrypt(String text, int[] key) {
        int numRows = (int) Math.ceil((double) text.length() / key.length);
        char[][] grid = new char[numRows][key.length];
        
        // Fill the grid with ' ' (spaces)
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
        
        // Populate the grid with characters from the text
        for (int i = 0; i < text.length(); i++) {
            grid[i / key.length][i % key.length] = text.charAt(i);
        }

        // Build the ciphertext by reading the columns in the order of the key
        StringBuilder ciphertext = new StringBuilder();
        for (int k : key) {
            for (int row = 0; row < numRows; row++) {
                if (grid[row][k - 1] != ' ') {
                    ciphertext.append(grid[row][k - 1]);
                }
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String text, int[] key) {
        int numRows = (int) Math.ceil((double) text.length() / key.length);
        char[][] grid = new char[numRows][key.length];

        // Fill the grid with ' ' (spaces)
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }

        // Populate the grid with characters from the text according to the key
        int textIndex = 0;
        for (int k : key) {
            for (int row = 0; row < numRows; row++) {
                if (textIndex < text.length()) {
                    grid[row][k - 1] = text.charAt(textIndex++);
                }
            }
        }

        // Rebuild the plaintext by reading the rows
        StringBuilder plaintext = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < key.length; col++) {
                if (grid[row][col] != ' ') {
                    plaintext.append(grid[row][col]);
                }
            }
        }
        return plaintext.toString();
    }
}
