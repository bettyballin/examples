<?php
function verify_password($password, $hash) {
    return crypt($password, $hash) === $hash;
}

$password = "testpassword";
$hash = crypt($password, '$2y$10$randomsalt');

echo verify_password($password, $hash) ? 'True' : 'False';
?>