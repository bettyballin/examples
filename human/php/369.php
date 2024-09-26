<?php

function createBlowfishHash($password) {
    $salt = '$2y$10$' . substr(str_shuffle('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'), 0, 22);
    return crypt($password, $salt);
}

function verifyBlowfishHash($password, $hash) {
    return crypt($password, $hash) === $hash;
}

function saveUpdatedPasswordHash($newHash) {
    // Replace this with your actual database update code
    echo "New hash saved: $newHash\n";
}

function checkAndMigrateHash($password, $hash) {
    if (substr($hash, 0, 4) == '$md5') {
        // Migrate!
        $hash = substr($hash, 4);
        if (!verifyBlowfishHash(md5($password), $hash)) {
            return false;
        }
        // valid hash, so let's generate a new one
        $newHash = createBlowfishHash($password);
        saveUpdatedPasswordHash($newHash);
        return true;
    } else {
        return verifyBlowfishHash($password, $hash);
    }
}

// Test the function
$password = 'mysecretpassword';
$oldMd5Hash = '$md5' . md5($password);
$newBfHash = createBlowfishHash($password);

echo "Checking old MD5 hash: " . (checkAndMigrateHash($password, $oldMd5Hash) ? 'Valid' : 'Invalid') . "\n";
echo "Checking new Blowfish hash: " . (checkAndMigrateHash($password, $newBfHash) ? 'Valid' : 'Invalid') . "\n";

?>