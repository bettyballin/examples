<?php
function login() {
    // Your login logic goes here
    // For demonstration purposes, I'll assume a simple true/false return
    return true;
}

if (!login()) {
    header("Location: /login");
    exit;
} else {
    header("Location: /home");
    exit;
}
?>