
// Before redirecting to the payment gateway
setcookie(session_name(), session_id(), [
    'expires' => time() + 60*60*24, // 1 day
    'path' => '/',
    'domain' => 'domain-of-A.com',
    'secure' => true,
    'httponly' => true,
    'samesite' => 'Lax' // Temporarily set SameSite to Lax
]);

// After
