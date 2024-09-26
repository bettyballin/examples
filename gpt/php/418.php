
$ipAllowed = array(
    '192.192.192', // Equivalent to 192.192.192.0/24
    '172.172.172'  // Equivalent to 172.172.172.0/24
);

$allowed = false;

foreach ($ipAllowed as $ip) {
    // Check if the REMOTE_ADDR starts with the allowed IP prefix
    if (substr($_SERVER['REMOTE_ADDR'], 0, strlen($ip)) === $ip) {
        $allowed = true;
        break;
    }
}

if (!$allowed) {
    header('HTTP/1.0 403 Forbidden');
    exit('You are not allowed to access this file.');
}

