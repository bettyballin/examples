<?php
session_start();

if (isset($_POST['uniqueCode']) && isset($_SESSION['unique_code'])) {
    if ($_POST['uniqueCode'] === $_SESSION['unique_code']) {
        // Run Code
        echo "Success";
    } else {
        http_response_code(403);
        echo "Forbidden";
    }
} else {
    http_response_code(400);
    echo "Bad Request";
}
?>