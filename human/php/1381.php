<?php

class MessageDigestPasswordEncoder extends BaseDigestPasswordEncoder {
    private $algorithm;
    private $iterations = 1;

    public function __construct($algorithm) {
        $this->algorithm = $algorithm;
    }

    public function encodePassword($rawPass, $salt) {
        $saltedPass = $this->mergePasswordAndSalt($rawPass, $salt, false);

        $messageDigest = $this->getMessageDigest();

        $digest = hash($this->algorithm, $saltedPass, true);

        for ($i = 1; $i < $this->iterations; $i++) {
            $digest = hash($this->algorithm, $digest, true);
        }

        if ($this->getEncodeHashAsBase64()) {
            return base64_encode($digest);
        } else {
            return bin2hex($digest);
        }
    }

    private function mergePasswordAndSalt($password, $salt, $strict) {
        // implement mergePasswordAndSalt logic here
    }

    private function getMessageDigest() {
        // implement getMessageDigest logic here
    }

    private function getEncodeHashAsBase64() {
        // implement getEncodeHashAsBase64 logic here
    }
}

// usage
$passwordEncoder = new MessageDigestPasswordEncoder('sha256');
$encodedPassword = $passwordEncoder->encodePassword('password', 'salt');
echo $encodedPassword;