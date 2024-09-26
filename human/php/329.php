<?php

namespace Acme\TestBundle\Service;

class Sha256Salted {
    public function encodePassword($raw, $salt) {
        $salted = $raw . '{' . $salt . '}';
        $digest = hash('sha256', $salted, true);
        return base64_encode($digest);
    }

    public function isPasswordValid($encoded, $raw, $salt) {
        $encodedRaw = $this->encodePassword($raw, $salt);
        return $encoded === $encodedRaw;
    }
}