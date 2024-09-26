<?php
function validateEmail($to) {
    if (!filter_var($to, FILTER_VALIDATE_EMAIL)) {
        return false;
    } else {
        return true;
    }
}

// Test the function
$email = "test@example.com";
var_dump(validateEmail($email));

$email = "invalid-email";
var_dump(validateEmail($email));
?>