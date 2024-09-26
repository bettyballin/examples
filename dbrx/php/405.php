<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Log;
use Illuminate\Http\Request;

class YourController extends Controller
{
    public function store(Request $request)
    {
        try {
            // Your logic here...
        } catch (\Exception $exception) {
            Log::channel('security')->error($exception->getMessage());
        }
    }
}