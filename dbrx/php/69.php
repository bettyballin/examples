<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;

Route::get('/api/showusers', [UserController::class, 'showUsers'])->middleware('auth');