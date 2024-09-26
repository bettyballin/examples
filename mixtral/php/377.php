public function start(Request $request, AuthenticationException $authException = null)
{
    /** @var string */
    $format = $request->getRequestFormat();

    // API request
    if (false !== strpos($format, 'json')) {
        throw new HttpException(Response::HTTP_UNAUTHORIZED);
    }

    return parent::start($request, $authException);
}