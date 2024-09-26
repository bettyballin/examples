<?php
$password = 'your_password';
$db_password = '$2y$10$random_characters'; // replace with actual hashed password

$isPasswordCorrect = password_verify($password, $db_password);

var_dump($isPasswordCorrect);
?>