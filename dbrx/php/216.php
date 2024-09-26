<?php

use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Carbon;

$user = Auth::user();
$user->last_activity = Carbon::now();
$user->save();