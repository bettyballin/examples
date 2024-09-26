<?php
function encryptId($id) {
    $hash = md5($id);
    return substr($hash, 0, 8); // Truncate the output to desired length.
}

// Test the function
$id = "12345";
$encrypted_id = encryptId($id);
print($encrypted_id);
?>