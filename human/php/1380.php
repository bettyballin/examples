<?php

class MessageDigestPasswordEncoder {
    private $algorithm;

    public function __construct($algorithm) {
        $this->algorithm = $algorithm;
    }

    // Add any necessary methods here
}

class ShaPasswordEncoder extends MessageDigestPasswordEncoder {
    public function __construct() {
        $this->__construct(1);
    }

    public function __construct($strength) {
        parent::__construct("SHA-" . $strength);
    }
}