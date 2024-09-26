<?php

use Illuminate\Support\Facades\Hash;
use App\Models\User;

// Assuming $request is an instance of Illuminate\Http\Request
$request = request();

// Create a new user instance.
$user = User::create([
    'name' => $request->input('name')
]);

// Generate the bcrypt hash for the given plaintext password.
$password = Hash::make($request->input('password'));

// Store the hashed password in the database.
$user->update(['password' => $password]);