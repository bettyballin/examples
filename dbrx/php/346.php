<?php

// Assuming you are using Laravel framework

use App\Models\User;
use Illuminate\Support\Facades\Hash;

// Assuming $data is an array with 'password', 'name', and 'email' keys

$user = User::create([
    'password' => Hash::make($data['password']),
    // other mass-assignable values...
]);

$user->name = $data['name'];
$user->email = $data['email'];

// Set any additional attributes here if necessary...

$user->save();

?>