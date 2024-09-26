
public function onAuthenticationSuccess(Request $request, TokenInterface $token, $providerKey)
{
    if ($targetPath = $this->getTargetPath($request->getSession(), $providerKey)) {
        return new RedirectResponse($targetPath);
    }

    // Get the User object from the TokenInterface
    $user = $token->getUser();

    // Check the type of user and redirect accordingly
    if ($user instanceof Client) {
        return new RedirectResponse($this->urlGenerator->generate('client_route'));
    } elseif ($user instanceof Employe) {
        return new RedirectResponse($this->urlGenerator->generate('admin_route'));
    } else {
        throw new \Exception('Unknown user type');
    }
}

