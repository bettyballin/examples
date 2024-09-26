<?php
session_start();

if(isset($_SESSION["role"]) && $_SESSION["role"] === "admin"){
    // Grant access to sensitive files
    echo "Access granted";
} else {
    // Deny access
    echo "Access denied";
}
?>