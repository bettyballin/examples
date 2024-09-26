<?php

use Illuminate\Support\Facades\Hash;
use App\Models\User;

// Assuming you are in a Laravel controller and $request is an instance of Illuminate\Http\Request
$user = User::create([
    'name' => $request->input('name')
]);

$password = Hash::make($request->input('password'));

$user->update(['password' => $password]);