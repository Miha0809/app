package com.slamy.app.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String getHash(String input) {
        try {
            // Create a SHA-512 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Convert the input string to a byte array and compute the hash
            byte[] data = md.digest(input.getBytes());

            // Create a StringBuilder to collect the bytes and create a string
            StringBuilder sBuilder = new StringBuilder();

            // Loop through each byte of the hashed data
            // and format each one as a hexadecimal string
            for (byte b : data) {
                sBuilder.append(String.format("%02x", b));
            }

            // Return the hexadecimal string
            return sBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Verify a hash against a string
    public static boolean verifyHash(String input, String hash) {
        // Hash the input
        String hashOfInput = getHash(input);

        // Compare the hashes using String.equals
        return hashOfInput != null && hashOfInput.equals(hash);
    }
}
