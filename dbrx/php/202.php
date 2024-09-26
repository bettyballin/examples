<?php
$user_input = 'your_password_here';
$hashed_password = password_hash($user_input, PASSWORD_BCRYPT);
echo $hashed_password;
?>