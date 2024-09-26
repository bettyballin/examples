<?php
$password = 'your_password_here';
$format_and_salt = '$2y$10$random_characters_here';

$hash = crypt($password, $format_and_salt);
echo $hash;
return $hash;
?>