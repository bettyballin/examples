<?php
function is_logged_in() {
    // Assuming you have a session variable 'logged_in' to track logged in users
    return (isset($_SESSION['logged_in']) && $_SESSION['logged_in'] == true);
}

function login_error_redirect() {
    // Redirect to login page
    header('Location: login.php');
}

if (!is_logged_in()){
    login_error_redirect();
    exit;
}
?>