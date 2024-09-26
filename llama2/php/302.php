<?php

use App\Http\Controllers\ResourceController;
use Illuminate\Support\Facades\Route;

Route::resource('/resources', ResourceController::class);

?>