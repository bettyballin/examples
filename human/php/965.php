<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Redirect;
use App\Models\User;

class UserController extends Controller
{
    public function store(Request $request)
    {
        $input = $request->all();
        // get the password and save it with its hash
        $input['password'] = Hash::make($input['password']);
        User::create($input);
        return Redirect::to('/');
    }
}