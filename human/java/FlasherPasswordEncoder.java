package com.flasher.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

public class FlasherPasswordEncoder implements PasswordEncoder {

    private static final String SALT = "your_salt_here"; // Replace with your actual salt

    @Override
    public String encode(CharSequence rawPassword) {
        return new MessageDigestPasswordEncoder("MD5").encode(rawPassword.toString() + SALT);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return new MessageDigestPasswordEncoder("MD5").encode(rawPassword.toString() + SALT).equals(encodedPassword);
    }

    public static void main(String[] args) {
        FlasherPasswordEncoder encoder = new FlasherPasswordEncoder();
        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Password matches: " + encoder.matches(rawPassword, encodedPassword));
    }
}