<?php

require 'vendor/autoload.php';

use Illuminate\Support\Facades\Hash;

$expectedHash = '$2a$08$UU.AJY.bcf0uJAp12WZvy.XE6CCgNAmuX8Hr17Pfkh3FRyFHWhBtO';
$actualHash = Hash::make('Test12345', [
    'salt' => 'UU.AJY.bcf0uJAp12WZvy',
    'prefix' => '$2a',
    'rounds' => 8
]);

if (hash_equals($expectedHash, $actualHash)) {
    echo "The hash values match!";
} else {
    echo "The hash values don't match.";
}