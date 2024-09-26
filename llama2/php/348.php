<?php
session_start();

// Create a new cookie with SameSite="Lax"
$newCookie = array(
    'name' => 'my_session',
    'value' => $_SESSION['my_session'],
    'expire' => time() + (60 * 60), // 1 hour
    'samesite' => 'Lax'
);

setcookie($newCookie['name'], $newCookie['value'], $newCookie['expire'], "/; samesite=Lax");

// Alternatively, for PHP 7.3+
setcookie($newCookie['name'], $newCookie['value'], $newCookie['expire'], "/", "", false, true);
?>