<?php

class MyPasswordEncoder {
    private $myUserObject;

    public function setMyUserObject($user) {
        $this->myUserObject = $user;
    }
}

class AdvancedUserInterface {
    // Implementation of AdvancedUserInterface
}

class SecurityContext {
    public function isGranted($role) {
        // Implementation of isGranted
    }
}

class TokenStorage {
    public function getToken() {
        // Implementation of getToken
    }
}

class Token {
    public function getUser() {
        // Implementation of getUser
    }
}

$passwordEncoder = new MyPasswordEncoder();

$securityContext = new SecurityContext();
$tokenStorage = new TokenStorage();

if ($securityContext->isGranted('IS_AUTHENTICATED_REMEMBERED')) {
    $token = $tokenStorage->getToken();
    $user = $token->getUser();
}

$passwordEncoder->setMyUserObject($user);