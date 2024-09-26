<?php
class User {
    function isAllowed() {
        // your logic here
        return true; // or false
    }
}

$user = new User();

// make sure user has permission
if (!$user->isAllowed()) {
    // redirect
    header('Location: /login.php');
    exit;
}