<?php
    session_start();
    $loggedIn = isset($_SESSION['user_id']);

    // If user is not logged in redirect them to login page
    if (!$loggedIn) {
        header('Location: login.php');
        exit;
    }

    // User is logged in continue with the rest of the script
    echo "You are logged in!";
?>