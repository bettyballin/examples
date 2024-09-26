<?php

// Start new session with $new_session set to TRUE.
if (session_status() === PHP_SESSION_NONE) {
    session_start(['name' => 'mySession', 'use_strict_mode' => true, 'cookie_lifetime' => 0, 'gc_maxlifetime' => 3600]);
}

// Check if user is logged in
if (!isset($_SESSION['user_id'])) {
    // User not authenticated; redirect to login page or similar.
    header('Location: login.php');
    exit;
} else {
    // Regenerate session ID and update the timestamp of last activity.
    regenerateSession();
}

function regenerateSession() : void {
    $_SESSION = array_intersect_key(
        $_SESSION, 
        ['user_id' => true]
    );

    if (session_status() === PHP_SESSION_ACTIVE) {
        session_regenerate_id(true);
    }
}