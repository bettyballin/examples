<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ResourceController;

Route::get('resource/{resource}/edit', [ResourceController::class, 'edit'])->middleware('can:update,resource');