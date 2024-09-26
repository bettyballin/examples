// src/Security/LoginFormAuthenticator.php

public function start(Request $request, AuthenticationException $authException = null)
{
    // Check if the request format is JSON (API call) or not
    /** @var string */
    $format = $request->getRequestFormat();

    if ('json' === $format || false !== strpos($format, 'json')) {
        throw new HttpException(Response::HTTP_UNAUTHORIZED);
    }

    return parent::start($request, $authException);
}