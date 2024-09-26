<?php
$oldPassword = password_hash('password', PASSWORD_DEFAULT);
$newPassword = 'password';

if (password_verify($newPassword, $oldPassword)) {
    echo 'Previously used password, please choose another';
}
?>