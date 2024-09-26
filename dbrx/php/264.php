<?php
$options = [
    'cost' => 11];

$userPassword = '<PASSWORD>';
$hash = password_hash($userPassword, PASSWORD_BCRYPT, $options);

if (password_verify($userPassword, $hash)) {
    echo "The user-provided password matches the stored hash.";
} else {
    echo "The passwords do not match or an error occurred during verification.";
}
?>