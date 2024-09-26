public function onAuthenticationSuccess(Request $request, TokenInterface $token, $providerKey)
{
    // ...

    /** @var \App\Entity\User $user */
    $user = $this->getUser();

    if ($user instanceof Employee) {
        return new RedirectResponse($this->urlGenerator->generate('admin'));
    } elseif ($user instanceof Client) {
        return new RedirectResponse($this->urlGenerator->generate('client'));
    }

    throw new \Exception('TODO: provide a valid redirect inside ' . __FILE__);
}