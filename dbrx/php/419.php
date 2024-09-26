// In app/Http/Middleware/ThrottleRequests.php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class ThrottleRequests
{
    public function handle(Request $request, Closure $next)
    {
        $maxAttempts = 60;
        $decayMinutes = 1;

        if ($this->shouldAttemptToRateLimit($request)) {
            $response = $next($request);

            $response->headers->set(
                'X-RateLimit-Limit',
                $maxAttempts
            );

            if ($response instanceof Response) {
                $response->setStatusCode(429, 'Too Many Requests');
            }
        }

        return $next($request);
    }

    protected function shouldAttemptToRateLimit(Request $request)
    {
        // Add your logic to check if rate limiting should be attempted.
    }
}

// In routes/api.php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\V1\UserController;

Route::get('/v1/user/{user}', [UserController::class, 'show'])
    ->middleware(['can:show', 'throttle:60,1']);

// In app/Exceptions/Handler.php

namespace App\Exceptions;

use Exception;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use Illuminate\Foundation\Exceptions\Handler as ExceptionHandler;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class Handler extends ExceptionHandler
{
    public function render($request, Exception $exception)
    {
        if ($exception instanceof ModelNotFoundException) {
            usleep(random_int(1000000, 3000000));

            return response()->json(['error' => 'Resource not found.'], 404);
        }

        return parent::render($request, $exception);
    }
}