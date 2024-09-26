<?php
$cookieParams = session_get_cookie_params();

// Update the array with new values
$cookieParams['lifetime'] = time() + (86400 * 30); // Cookie will expire after 30 days
$cookieParams['path']        = '/';
$cookieParams['domain']      = '.example.com';
$cookieParams['secure']      = true;
$cookieParams['httponly']    = true;

// Set the new cookie parameters
session_set_cookie_params($cookieParams);

// Start session
session_start();
?>