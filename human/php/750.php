<?php
$inputPassword = "your_input_password"; // replace with your input password
$hash = '$2y$10$random_hash_value'; // replace with your stored hash value

if (password_verify($inputPassword, $hash)) {
    echo "Password OK";
} else {
    echo "Wrong password";
}
?>