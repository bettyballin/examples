<?php
require('PasswordHash.php');

$password = 'your_password_here'; // replace with the password to be hashed

$pwdHasher = new PasswordHash(8, FALSE);

// $hash is what you would store in your database
$hash = $pwdHasher->HashPassword($password);

// $hash would be the $hash stored in your database for this user
$checked = $pwdHasher->CheckPassword($password, $hash);
if ($checked) {
    echo 'password correct';
} else {
    echo 'wrong credentials';
}
?>