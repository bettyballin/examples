<?php
$input_password = 'user_input_password';
$stored_hash = '$2y$10$randomsalt-generatedby-password_hash()';

if (password_verify($input_password, $stored_hash)) {
    echo 'Password is valid!';
} else {
    echo 'Invalid password.';
}
?>