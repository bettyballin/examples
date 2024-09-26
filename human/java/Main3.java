package com.example.trusted;

import java.security.AccessControlException;
import java.security.Permission;

public class Main {

    private static final Permission EXIT_VM_PERM = new RuntimePermission("exitVM.*");

    public static void main(String... args) {
        System.setSecurityManager(new SecurityManager());
        try {
            Test.testExitVm();
        }
        catch (AccessControlException ace) {
            Permission deniedPerm = ace.getPermission();
            if (EXIT_VM_PERM.implies(deniedPerm)) {
                ace.printStackTrace();
                handleUnauthorizedVmExitAttempt(Integer.parseInt(deniedPerm.getName().replace("exitVM.", "")));
            }
        }
    }

    private static void handleUnauthorizedVmExitAttempt(int exitCode) {
        System.out.println("here let me do it for you");
        System.exit(exitCode);
    }

}

class Test {
    public static void testExitVm() {
        System.exit(1);
    }
}