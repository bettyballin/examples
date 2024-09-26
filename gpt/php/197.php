
$allowed_ips = ['your.testing.ip.address'];
if (!in_array($_SERVER['REMOTE_ADDR'], $allowed_ips)) {
    exit();
}

