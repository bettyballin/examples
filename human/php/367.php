<?php
function verifyBlowfishHash($password, $hash) {
    return $hash == crypt($password, $hash);
}

// Test the function
$password = "testpassword";
$hash = crypt($password, '$2y$07$randomsalt$');
echo "Original Password: $password\n";
echo "Generated Hash: $hash\n";
echo "Verification Result: " . (verifyBlowfishHash($password, $hash) ? "True" : "False") . "\n";
?>