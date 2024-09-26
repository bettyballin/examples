// app/Http/Middleware/CheckUserAuthorization.php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;

class CheckUserAuthorization
{
    public function handle($request, Closure $next)
    {
        if (!Auth::check() || !$this->userCanAccessResource()) {
            return response(['message' => 'Unauthorized'], 403);
        }

        return $next($request);
    }

    private function userCanAccessResource(): bool
    {
        // Implement your logic to check if the authenticated
        // user can access this resource.

        // For example you could use Laravel's built-in policies:

        return Auth::user()->can('show', $this->getUserFromRoute());
    }

    private function getUserFromRoute(): \App\Models\User
    {
        if (!request()->route()) {
            throw new \RuntimeException("No route found.");
        }

        return request()->route('user');
    }
}