<?php
session_start();

// Store failed attempts in session
if (!isset($_SESSION['failed_attempts'])) {
    $_SESSION['failed_attempts'] = 0;
}

$maxAttempts = 5;

function isBlocked()
{
    global $maxAttempts;

    if ($_SESSION['failed_attempts'] >= $maxAttempts) {
        return true;
    }

    // Reset failed attempts after a certain time
    if (isset($_SESSION['last_attempt']) && time() - $_SESSION['last_attempt'] > 3600) {
        unset($_SESSION['failed_attempts']);
        unset($_SESSION['last_attempt']);

        return false;
    }

    // Increment failed attempts
    $_SESSION['failed_attempts']++;

    if (!isset($_SESSION['last_attempt'])) {
        $_SESSION['last_attempt'] = time();
    }

    return false;
}

if (isBlocked()) {
    echo "You are blocked!";
} else {
    echo "You can try again.";
}
?>