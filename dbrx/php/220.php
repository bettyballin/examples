<?php

function password_encrypt($password)
{
    $hash_format = "$2y$10$";
    $salt_length = 22;
    $unique_random_string = md5(uniqid(mt_rand(), true));
    $base64_string = base64_encode(substr($unique_random_string, 0, $salt_length - strlen($hash_format)));
    $modified_base_64_string = str_replace('+', '.', $base64_string);
    $format_and_salt = $hash_format . $modified_base_64_string;
    $hash = crypt($password, $format_and_salt);

    return $hash;
}

$password = "your_password_here";
$encrypted_password = password_encrypt($password);

print($encrypted_password);

?>