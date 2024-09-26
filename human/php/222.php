<?php

$user = 'test_user';
$authToken = 'test_auth_token';
$digestToken = 'test_digest_token';
$hash = 'test_hash';

$stub = $user . ':' . $authToken;
if ($hash == hash_hmac('sha256', $stub, $digestToken)) {
    echo "Valid user";
} else {
    echo "Not valid";
}