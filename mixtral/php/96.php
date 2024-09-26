<?php

$user_input = 'your_password'; // replace with user input
$stored_hash = 'your_stored_hash'; // replace with stored hash

if (hash_equals(crypt($user_input, $stored_hash), $stored_hash)) {
    echo "Password is correct";
} else {
    echo "Password is incorrect";
}

?>