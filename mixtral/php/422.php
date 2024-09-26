try {
    $token = new CsrfToken('login', $request->get('_csrf_token'));
    if (!$this->csrfTokenManager->isTokenValid($token)) {
        throw new InvalidCsrfTokenException();
    }

    //...

    return new Passport(
        // ...
    );
} catch (InvalidCsrfTokenException $e) {
    // handle exception
}