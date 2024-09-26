<?php
$password = 'myVeryStrongPasswordThanNoneCouldBreak';
$options = [
    'cost' => 12];
$hashed_password = password_hash($password, PASSWORD_BCRYPT, $options);

// Store the hashed password in your database

// When checking a user's input:
$user_input = $_POST['user_input'];
if (password_verify($user_input, $hashed_password)) {
    echo "Password is correct";
} else {
    echo "Invalid credentials";
}
?>