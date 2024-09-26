<?php

interface TokenListener {
    public function tokenReceived($token);
}

class TokenInterface {
    private $context;

    public function __construct(TokenListener $context) {
        $this->context = $context;
    }
}

// Example usage:
class TokenListenerImpl implements TokenListener {
    public function tokenReceived($token) {
        // handle token received
    }
}

$listener = new TokenListenerImpl();
$tokenInterface = new TokenInterface($listener);