<?php
$input = '1_abcd_2';

$valid = preg_match('/^[\d]_[a-z]{4}_[\d]$/', $input);
if ($valid) {
    // process input
    $someString = substr($input, strripos($input, "_") + 1);
    $i = (int) $someString;
    echo '$i = ', $i;
} else {
    // Handle invalid format
    echo 'Malformed data. Potentially malicious';
}
?>