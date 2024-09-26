package com.example.untrusted;

public class Test {

    public static void main(String[] args) {
        testExitVm();
    }

    public static void testExitVm() {
        System.out.println("May I...?!");
        System.exit(-1);
    }

}