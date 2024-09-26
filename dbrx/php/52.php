<?php
$input = "1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";
if (preg_match('/^[a-zA-Z0-9]{64}$/', $input)) {
    echo "\$input is a valid 32-byte hexadecimal number i.e an Adobe Stratus ID.";
} else {
    echo "\$input is not a valid 32-byte hexadecimal number.";
}
?>