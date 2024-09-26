<?php

// Start session
session_start();

// Set maximum allowed request count for specific period of time.
$max_request_count = 10;
$request_period_in_seconds = 3600; // one hour in seconds (60 * 60)

$ip_address = $_SERVER['REMOTE_ADDR'];
$current_time_stamp = time();

// Check if IP address is already blocked or not?
if (!isset($_SESSION[$ip_address])) {
    $blocked_ip_addresses = json_decode(file_get_contents('blocked_ips.json'), true);

    // If current IP address exists in the list of banned IPs then block it.
    if (in_array($ip_address, array_keys($blocked_ip_addresses))) {
        if ($blocked_ip_addresses[$ip_address]['timestamp'] > $current_time_stamp) {
            die("Your access has been blocked due to abusive behavior.");
        } else {
            unset($blocked_ip_addresses[$ip_address]);
            file_put_contents('blocked_ips.json', json_encode($blocked_ip_addresses));
        }
    }
} else {
    $last_request_time_stamp = $_SESSION[$ip_address];
}

// Check whether current request is within allowed limit or not?
if (!isset($_SESSION['request_count'])) {
    // Initialize session variable for storing number of requests made by user.
    $_SESSION['request_count'] = 0;
}

$_SESSION['request_count']++;

$elapsed_time_in_seconds = $current_time_stamp - (int)$last_request_time_stamp;

// If elapsed time is less than allowed period then block the IP address temporarily.
if ($elapsed_time_in_seconds < $request_period_in_seconds) {
    if ($_SESSION['request_count'] > $max_request_count) {
        // Block current IP address for specific duration by storing it in JSON file along with timestamp when ban will be lifted off automatically after specified time period expires..
        $blocked_ip_addresses = json_decode(file_get_contents('blocked_ips.json'), true);
        $blocked_ip_addresses[$ip_address] = ['timestamp' => ($current_time_stamp + $request_period_in_seconds)];
        file_put_contents('blocked_ips.json', json_encode($blocked_ip_addresses));

        // Clear session variables related to current user.
        unset($_SESSION['request_count']);
        unset($_SESSION[$ip_address]);

        die("Your access has been blocked due to abusive behavior.");
    }
} else {
    // Reset request count and last request time stamp since enough duration passed between two consecutive requests made by same IP address..
    $_SESSION['request_count'] = 0;
    $_SESSION[$ip_address] = $current_time_stamp;
}

// Store current request time stamp and IP address in session variables.
$_SESSION[$ip_address] = $current_time_stamp;

?>