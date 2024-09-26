<?php

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Route;
use App\Http\Middleware\VerifyCsrfToken;

Route::get('example', [Controller::class, 'example'])->middleware(VerifyCsrfToken::class);