<?php
function checkKey($derivedKey, $expectedDerivedKey) {
    return ($derivedKey === $expectedDerivedKey);
}

// Test the function
$derivedKey = "test_key";
$expectedDerivedKey = "test_key";
echo var_export(checkKey($derivedKey, $expectedDerivedKey), true) . "\n";

$derivedKey = "wrong_key";
$expectedDerivedKey = "test_key";
echo var_export(checkKey($derivedKey, $expectedDerivedKey), true) . "\n";
?>