namespace App\Http\Middleware;

use Illuminate\Foundation\Http\Middleware\VerifyCsrfToken as Middleware;

class CsrfForAllRequests extends Middleware
{
    protected function tokensMatch($request)
    {
        $token = $this->getTokenFromRequest($request);

        return is_string($request->session()->token()) &&
                is_string($token) &&
                hash_equals((string)$request->session()->token(), sha1(trim($token)));
    }
}