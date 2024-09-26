public function onAuthenticationFailure(Request $request, AuthenticationException $exception): ?Response
{
    if ($exception instanceof InvalidCredentialsException) {
        // logic here
    }
}