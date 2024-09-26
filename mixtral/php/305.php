namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;

class ExpireSession
{
    public function handle($request, Closure $next)
    {
        if (Auth::check()) {
            return redirect('/logout');
        }

        return $next($request);
    }
}

// In Kernel.php
protected $routeMiddleware = [
    'expired.session' => \App\Http\Middleware\ExpireSession::class
];