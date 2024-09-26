<?php
function isSecurityViolation($dir) {
    // Example implementation, replace with your own security check
    $restrictedDirs = array('/etc', '/var', '/usr');
    return in_array($dir, $restrictedDirs);
}

$dir = '/etc'; // Example directory to check

if (isSecurityViolation($dir)) {
    die('No soup for you.');
} else {
    print("Access granted to $dir.");
}
?>