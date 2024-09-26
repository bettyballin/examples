<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

class LogoutController extends Controller
{
    public function logout()
    {
        $user = Auth::user();
        Auth::logout();

        if ($user) {
            $user->update(['session_id' => null]);
        }

        return redirect('/');
    }
}