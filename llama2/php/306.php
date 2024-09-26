// app/Http/Kernel.php

namespace App\Http;

use Illuminate\Foundation\Http\Kernel as HttpKernel;

class Kernel extends HttpKernel
{
    // ...

    protected $middleware = [
        // ...
        \App\Http\Middleware\SetSecureCookie::class
    ];

    // ...
}

// app/Http/Middleware/SetSecureCookie.php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

class SetSecureCookie
{
    public function handle(Request $request, Closure $next)
    {
        $response = $next($request);

        foreach ($response->headers->getCookies() as $cookie) {
            $cookie->setSecure(true);
        }

        return $response;
    }
}