<?php
define('SALT_LENGTH', 16);
$pepper = 'your_secret_pepper_string';

if ($salt == '')
{
    $salt = substr(hash('sha512',uniqid(rand(), true).$pepper.microtime()), 0, SALT_LENGTH);
}
print($salt);
?>