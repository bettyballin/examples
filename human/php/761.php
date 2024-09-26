<?php
session_start();

$csrf_key   = "TOKEN_" . mt_rand(0, mt_getrandmax());
$csrf_token = hash("sha512", mt_rand(0, mt_getrandmax()));

// Store the key/token pair in session
$_SESSION[$csrf_key] = $csrf_token;