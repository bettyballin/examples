<?php
$userEnteredPass = 'your_password_here';
$storedHashedPass = 'your_hashed_password_here';

if (password_verify($userEnteredPass, $storedHashedPass)) {
    echo "Password is correct";
} else {
    echo "Wrong password";
}
?>