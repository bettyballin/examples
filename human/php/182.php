<?php

// Assuming $saltFromDatabase and $hashFromDatabase are retrieved from database
$saltFromDatabase = 'your_salt_here';
$hashFromDatabase = 'your_hash_here';

if (isset($_POST['password'])) {
    if (hash_hmac("sha256", $_POST['password'], $saltFromDatabase) === $hashFromDatabase) {
        $login = true;
    } else {
        $login = false;
    }
} else {
    $login = false;
}

var_dump($login);

?>