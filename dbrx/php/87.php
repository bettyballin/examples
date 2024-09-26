<?php

// Start a secure PHP session
function startSecureSession()
{
    // Set custom session settings
    ini_set('session.cookie_httponly', 1);
    ini_set('session.use_only_cookies', 1);

    $secure = isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on';
    if ($secure) {
        ini_set('session.cookie_secure', true);
    }

    // Set the SameSite flag to Strict or Lax
    session_set_cookie_params([
        'samesite' => 'Strict'
    ]);

    // Start a new PHP session
    session_start();

    // Regenerate the session ID if it's not fresh
    if (session_status() === PHP_SESSION_ACTIVE && !isset($_SESSION['CREATED'])) {
        session_regenerate_id(true);
        $_SESSION['CREATED'] = time();
    }
}

// End and destroy a secure PHP session
function endSecureSession()
{
    // Unset all of the session variables.
    if (session_status() === PHP_SESSION_ACTIVE) {
        unset($_SESSION['_token']);
        
        foreach ($_COOKIE as $key => $value) {
            setcookie($key, '', time()-3600);
        }

        $_SESSION = [];
        session_destroy();
   }
}

// Generate a CSRF token
function generateCsrfToken()
{
    if (!isset($_SESSION['_token'])) {
        // Create the new token and store it in the session.
        $new_token = bin2hex(random_bytes(32));
        $_SESSION['_token'] = $new_token;
    }

    return $_SESSION['_token'];
}

// Verify a CSRF token
function verifyCsrfToken($submitted_token)
{
    // Check if the session token exists and matches the submitted token
    if (isset($_SESSION['_token']) && hash_equals($_SESSION['_token'], $submitted_token)) {
        return true;
    } else {
        return false;
    }
}

// Usage
startSecureSession();
$token = generateCsrfToken();
echo "Generated Token: $token\n";

if (verifyCsrfToken($token)) {
    echo "Token is valid.\n";
} else {
    echo "Token is invalid.\n";
}

endSecureSession();

?>