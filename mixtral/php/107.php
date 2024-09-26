<?php

$isDevMode = true; // or false

try {
    // Your code here
    // For example:
    $x = 1 / 0;
}
catch (\Exception $e) {
    error_log($e->getMessage());

    if ($isDevMode) {
        throw $e;
    }

    echo 'Server Error!';

    exit(1);
}