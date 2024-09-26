<?php

function exceeded($ip) {
    $limit = 5;
    $span = 15;

    // Connect to redis server (assuming it is running locally)
    $redis = new Redis();
    $redis->connect('127.0.0.1', 6379);

    // Get current time in microseconds
    $now = microtime(true) * 1000000;
    
    // Calculate the key for this IP address and rate limit window
    $key = "rate_limit:{$ip}:{$span}";

    // Check if there is an existing token bucket entry for this user/IP combination
    $bucket = json_decode($redis->get($key), true);

    if (!$bucket) {
        // No previous entries found create a new one with the current time and initial hit count of 1
        $bucket = [
            'last_update' => $now,
            'hits' => 1,
        ];
    } else {
        // Calculate elapsed microseconds since last update
        $elapsed_us = ($now - $bucket['last_update']) / 1000000;

        if ($elapsed_us > $span) {
            // Reset the bucket if the elapsed time exceeds the rate limit window
            $bucket = [
                'last_update' => $now,
                'hits' => 1,
            ];
        } else {
            // Increment the hit count if the elapsed time does not exceed the rate limit window
            $bucket['hits']++;
            if ($bucket['hits'] > $limit) {
                return true;
            }
        }
    }

    // Store the updated bucket in Redis
    $redis->set($key, json_encode($bucket));

    return false;
}

// Test the function
$ip = '192.168.1.1';
if (exceeded($ip)) {
    echo "Rate limit exceeded for IP: $ip";
} else {
    echo "Rate limit not exceeded for IP: $ip";
}

?>