
// app/Http/Middleware/VerifyCsrfTokenForGetRequests.php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Foundation\Http\Middleware\VerifyCsrfToken as BaseVerifier;

class VerifyCsrfTokenForGetRequests extends BaseVerifier
{
    public function handle($request,
