<?php

use Illuminate\Support\Facades\Hash;

$plainUserInput = 'user_input_password';
$hashedPasswordFromDatabase = Hash::make('original_password');

if(Hash::check($plainUserInput, $hashedPasswordFromDatabase)) {
    echo "Password is correct";
} else {
    echo "Wrong credentials";
}

?>