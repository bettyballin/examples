<?php
session_start();

if (isset($_SESSION['logged_in']) && $_SESSION['logged_in']) {
    // User logged in
    echo "You are logged in!";
} else {
    // User not logged in
    echo "You are not logged in!";
}
?>