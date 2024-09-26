<?php

// Generate 1000 random strings as potential session IDs
for ($i = 1; $i <= 1000; $i++) {
    // Create a new string with the desired length (e.g. 32 characters)
    $sessionId = substr(str_shuffle(MD5(microtime())), 0, 32);

    // Set the generated ID as session_id
    session_id($sessionId);
    
    // Start or resume PHP session using this custom ID
    if (!session_start()) {
        die('Failed to start/resume session');
    }

    // Close current session and free up resources
    session_write_close();
}

?>