
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Http\EntryPoint\AuthenticationEntryPointInterface;

class YourAuthenticator implements AuthenticationEntryPointInterface
{
    // ... (other methods)

    public function start(Request $request, AuthenticationException $authException = null)
    {
        if ('json' === $request->getRequestFormat()) {
            $data = [
                // you might translate this message or use a different one
                'message' => 'Authentication Required'
            ];

            return new JsonResponse($data, JsonResponse::HTTP_UNAUTHORIZED);
        }

        $url = $this->getLoginUrl();
        return new RedirectResponse($url);
    }

    // ... (other methods)
}

