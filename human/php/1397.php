<?php

$yourSecretKey = 'your_secret_key_here'; // replace with your secret key

foreach ($_POST as $key => $value) {
    if ($key === 'hash') {     // Checksum value is separate from all other fields and shouldn't be included in the hash
        $checksum = $value;
    } else {
        $input[$key] = $value;
    }
}

$hash = hash('sha512', $yourSecretKey . serialize($input));
if ($hash === $checksum) {
    $valid = true;
} else {
    $valid = false;
}

echo $valid ? 'Valid' : 'Invalid';

?>