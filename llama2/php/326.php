<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class StorageMiddleware
{
    public function handle(Request $request, Closure $next)
    {
        // Check if the user is authenticated
        if (! Auth::check()) {
            return response()->json(['error' => 'Unauthorized'], 401);
        }

        // Apply the policy to the request
        if (!$request->user()->can('view', Storage::path($request->path()))) {
            return response()->json(['error' => 'Forbidden'], 403);
        }

        return $next($request);
    }
}