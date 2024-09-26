<?php
$password = 'your_password_here';
$user = new stdClass();
$user->pass = password_hash('your_password_here', PASSWORD_DEFAULT);

if (password_verify($password, $user->pass)) {
    echo 'good';
} else {
    echo 'error';
}
?>