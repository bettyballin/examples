<?php
function validate_int($value) {
    return preg_match('/^\d+$/', $value);
}

// Test the function
echo validate_int("123") . "\n";  // Expected output: 1
echo validate_int("123abc") . "\n";  // Expected output: 0
?>