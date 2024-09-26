<?php
function isSecurityViolation($dir) {
    if (preg_match('#https?://#i', $dir)) {
        return true;
    }

    // no directory traversal attempts
    if (strpos($dir, '../') !== false) {
        return true;
    }

    if (strpos($dir, "\x00") !== false) {
        return true;
    }

    if (strpos($dir, '%00') !== false) {
        return true;
    }

    return false;
}

// Test the function
$dirs = array(
    'http://example.com',
    '../path/to/dir',
    "path/to/dir\x00",
    'path/to/dir%00',
    '/path/to/dir'
);

foreach ($dirs as $dir) {
    echo "Is '$dir' a security violation? " . (isSecurityViolation($dir) ? 'Yes' : 'No') . "\n";
}
?>