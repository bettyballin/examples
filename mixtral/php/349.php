<?php

// Assuming you are using Laravel framework

use App\Models\User;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;

// Assuming this code is in a controller method
public function createUser(Request $request)
{
    $data = $request->all();

    $user = new User();

    // Set guarded/non-fillable fields
    $user->name = $request->input('name');
    $user->email = $request->input('email');

    // Hash the password
    $password = Hash::make($data['password']);

    // Fill mass assignable attributes
    $user->fill([
        'province' => $data['province'],
        'city'   => $data['city'],
        'street'  => $data['street'],
        // ...
    ]);

    // Set password
    $user->password = $password;

    // Save the user
    $user->save();
}


Note: I assumed the code is in a Laravel controller method. If not, please adjust the namespace and class usage accordingly. Also, the code assumes that the `User` model, `Hash` facade and `Request` class are properly defined and configured in your application.