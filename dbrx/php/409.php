<?php
// Change Session Cookie Parameters for redirecting user to payment service (B)
session_set_cookie_params([
    'lifetime' => 0,
    'path'     => '/',
    'domain'   => '.your-domain.com', // Your domain here with leading dot
    'secure'   => true,
    'httponly' => true,
    'samesite' => 'Lax'
]);
session_start();

// Perform payment confirmation logic

// Change Session Cookie Parameters back to Strict after redirecting user from B to A
session_set_cookie_params([
    'lifetime' => 0,
    'path'     => '/',
    'domain'   => '.your-domain.com', // Your domain here with leading dot
    'secure'   => true,
    'httponly' => true,
    'samesite' => 'Strict'
]);
session_start();

// Perform post-payment logic
?>