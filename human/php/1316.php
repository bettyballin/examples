<?php

function _basename($internal_encoding, $filename) {
    // implementation of _basename function
    // for simplicity, we'll use the built-in basename function
    return basename($filename);
}

$filename = 'path/to/file.txt';

$s = _basename('UTF-8', $filename);
if (!$s) {
    $s = $filename;
}

print($s . "\n");

?>