<?php

interface TokenStorageInterface {
}

class CsrfTokenManager {
    public function __construct(TokenStorageInterface $tokenStorage) {
    }
}

class LifetimeCsrfTokenStorage implements TokenStorageInterface {
    // ...
}

$tokenManager = new CsrfTokenManager(new LifetimeCsrfTokenStorage());