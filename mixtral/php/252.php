<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Storage;

class AvatarController extends Controller
{
    public function uploadAvatar(Request $request)
    {
        $filename = time();

        $path = $request->file('avatar')->storeAs(
            'uploads/users/' . Auth::id(),
            md5($filename) . '.png'
        );

        return response()->json(['path' => $path]);
    }

    public function downloadAvatar()
    {
        $path = 'uploads/users/' . Auth::id() . '/' . md5(time()) . '.png';

        return Storage::download($path);
    }
}



// In routes/web.php or routes/api.php
Route::post('/upload-avatar', 'AvatarController@uploadAvatar');
Route::get('/download-avatar', 'AvatarController@downloadAvatar');