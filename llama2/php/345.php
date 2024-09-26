<?php

use Illuminate\Support\Facades\Log;

// Assuming you're in a Laravel controller method
public function login(Request $request)
{
    // After user submits login credentials
    Log::stack('default')->info('User logged in', ['username' => $request->input('username')]);
}


Note: Make sure to replace `'default'` with your actual log stack name if it's different.