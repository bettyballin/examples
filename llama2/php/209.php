<?php
// In your routes file (web.php)

use Illuminate\Support\Facades\Route;

Route::get('/embed', function () {
    return view('embed');
});