public function onAuthenticationSuccess(Request $request, TokenInterface $token, $providerKey)
{
    // ...

    if ($this->isGranted('ROLE_ADMIN')) {
        return new RedirectResponse($this->urlGenerator->generate('admin'));
    } elseif ($this->isGranted('ROLE_CUSTOMER')) {
        return new RedirectResponse($this->urlGenerator->generate('client'));
    }

    throw new \Exception('TODO: provide a valid redirect inside ' . __FILE__);
}