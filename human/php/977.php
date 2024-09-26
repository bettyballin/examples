<?php

const HASH_LEN = 32; // assuming 32 character hash
const HASH_ALGO = 'md5'; // using md5 for demonstration purposes

function get_hashed_characters($password, $secret_word) {
    $char_store = "";

    for ($i = 0; $i < strlen($secret_word); $i++) {
        $char = $secret_word[$i];
        $hashed_char = hash(HASH_ALGO, $char . $password);
        $char_store .= $hashed_char;
    }

    return $char_store;
}

function check_hashed_char($password, $hash_store, $char_index, $char) {
    if (strlen($hash_store) < $char_index * HASH_LEN + HASH_LEN) {
        return false;
    }

    $hashed_char = substr($hash_store, $char_index * HASH_LEN, HASH_LEN);

    return hash(HASH_ALGO, $char . $password) === $hashed_char;
}

// Example usage:
$password = 'mysecretpassword';
$secret_word = 'hello';
$hash_store = get_hashed_characters($password, $secret_word);

echo $hash_store . "\n";

$char_index = 2;
$char = 'l';
$result = check_hashed_char($password, $hash_store, $char_index, $char);

var_dump($result);

?>