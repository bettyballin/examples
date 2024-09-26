<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Auth;
use Intervention\Image\Facades\Image;

Route::get('images/{imageName}', function($imageName) {
    // Check database to ensure currently logged in user has acces to the image.
    $image = DB::table('images')->where('name', $imageName)->where('user', Auth::user()->user_name)->first();
    if(!is_null($image)) {
        return Image::make($image->full_path)->response('png');
    } else {
        return Image::make('defaultNotAllowedImage.png')->response('png');
    }
});