<?php

use Illuminate\Support\Facades\Hash;

$plainTextPassword = 'Test12345';
$hashedOldPassword = '$2y$08$UU.AJY.bcf0uJAp12WZvy.XE6CCgNAmuX8Hr17Pfkh3FRyFHWhBtO';

if (Hash::check($plainTextPassword, $hashedOldPassword)) {
    // If old hash matches

    // Rehash and save with updated algorithm
    $newHashed = Hash::make($plainTextPassword);
    echo "New hashed password: $newHashed\n";
}

// Then use the new hashing method for future checks
if (Hash::check('Test12345', '$2y$08$UU.AJY.bcf0uJAp12WZvy.XE6CCgNAmuX8Hr17Pfkh3FRyFHWhBtO')) {
    echo "Password matches\n";
}