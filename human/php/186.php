<?php

function makeRandomString($length = 32) {
    $characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }
    return $randomString;
}

function storeNonce($id, $nonce) {
    // Assuming a database connection is established
    // For simplicity, using a file-based storage here
    file_put_contents("nonce_$id.txt", $nonce);
}

function getNonce($id) {
    // Fetch the nonce from storage
    return trim(file_get_contents("nonce_$id.txt"));
}

function removeNonce($id, $nonce) {
    // Remove the nonce from storage
    unlink("nonce_$id.txt");
}

function identifyRequest() {
    // For simplicity, using the session ID here
    session_start();
    return session_id();
}

function getNonceAction() {
    $id = identifyRequest();
    $nonce = hash('sha512', makeRandomString());
    storeNonce($id, $nonce);
    return $nonce;
}

function verifyNonceAction($data, $cnonce, $hash) {
    $id = identifyRequest();
    $nonce = getNonce($id);
    removeNonce($id, $nonce);
    $testHash = hash('sha512', $nonce . $cnonce . $data);
    return $testHash == $hash;
}

// Usage example:
$nonce = getNonceAction();
echo "Nonce: $nonce\n";

$data = "Hello, World!";
$cnonce = makeRandomString();
$hash = hash('sha512', $nonce . $cnonce . $data);

$isValid = verifyNonceAction($data, $cnonce, $hash);
echo "Is valid: " . ($isValid ? "Yes" : "No") . "\n";

?>