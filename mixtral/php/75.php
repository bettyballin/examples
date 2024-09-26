<?php

$token = "some_insecure_token";

try {
    if (false === $token || strlen($token) < 16){
        throw new Exception('Unable to generate a secure token.');
    }
} catch (Exception $e) {
    echo $e->getMessage();
}