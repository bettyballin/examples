protected $middleware = [
    // ...
    \App\Http\Middleware\StorageMiddleware::class
];

// Assuming this is in a Laravel App\Http\Kernel.php file
// Create the StorageMiddleware class in App\Http\Middleware\ folder

// File: app/Http/Middleware/StorageMiddleware.php

namespace App\Http\Middleware;

use Closure;

class StorageMiddleware
{
    public function handle($request, Closure $next)
    {
        // Your middleware logic here
        return $next($request);
    }
}