<?php

$referer = $_SERVER['HTTP_REFERER'];
if (empty($referer) || strpos($referer, 'http://your-website.com') !== 0) {
    echo "Invalid referer header";
    exit;
}

$ip = $_SERVER['REMOTE_ADDR'];
$allowedIps = array('192.168.0.0/30', '10.0.0.0/24');
if (!in_array($ip, $allowedIps)) {
    echo "Invalid IP address";
    exit;
}

$nonce = $_POST['nonce'];
function generate_nonce() {
    // implement your nonce generation logic here
    return 'your_nonce_value';
}
if (empty($nonce) || $nonce !== generate_nonce()) {
    echo "Invalid nonce";
    exit;
}

// rest of your code here

?>