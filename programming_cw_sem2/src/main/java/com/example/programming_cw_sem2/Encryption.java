package com.example.programming_cw_sem2;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Encryption {
    private static final String encryptionAlgorithm = "AES";
    private static final String encryptionKey = "ThisIsTheEncryptionAndDecryptionKey";

    //Encrypting data
    public static String encryptData(String data) {
        try {
            // Ensure the encryption key is 256 bits (32 bytes) long
            byte[] keyBytes = new byte[32];
            System.arraycopy(encryptionKey.getBytes(StandardCharsets.UTF_8), 0, keyBytes, 0, Math.min(encryptionKey.getBytes(StandardCharsets.UTF_8).length, keyBytes.length));
            // Generate a SecretKeySpec from the encryption key
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, encryptionAlgorithm);
            // Initialize the Cipher with AES encryption mode
            Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            // Encrypt the data
            byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            // Convert the encrypted bytes to a Base64-encoded string
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println("\u001B[31mEncryption failed\u001B[39m");
        }
        return null;
    }
    //Decrypting data
    public static String decryptData(String encryptedData) {
        try {
            // Ensure the encryption key is 256 bits (32 bytes) long
            byte[] keyBytes = new byte[32];
            System.arraycopy(encryptionKey.getBytes(StandardCharsets.UTF_8), 0, keyBytes, 0, Math.min(encryptionKey.getBytes(StandardCharsets.UTF_8).length, keyBytes.length));
            // Generate a SecretKeySpec from the encryption key
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, encryptionAlgorithm);
            // Initialize the Cipher with AES decryption mode
            Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            // Decode the Base64-encoded encrypted data and decrypt it
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            // Convert the decrypted bytes to a UTF-8 string
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("\u001B[31mDecryption failed\u001B[39m");
        }
        return null;
    }
}
