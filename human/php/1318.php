/**
 * @param Request $request
 * @param PasswordAuthenticator $authenticator
 * @param UserProvider $provider
 * @param Session $session
 * @param TokenStorageInterface $storage
 * @return \Symfony\Component\HttpFoundation\RedirectResponse|Response
 *
 * @Route("/login/check", name="user.login.check", methods={"POST"})
 */
public function checkLoginUser(
    Request $request,
    PasswordAuthenticator $authenticator,
    UserProvider $provider,
    Session $session,
    TokenStorageInterface $storage
) {
    $token = $authenticator->createToken(
        $request,
        $request->request->get('_username'),
        $request->request->get('_password'),
        'UserProvider'
    );

    $authenticator->supportsToken($token, 'UserProvider');
    try {
        $newToken = $authenticator->authenticateToken($token, $provider, $token->getUser());

        $storage->setToken($newToken);
        $session->set('_security_main', serialize($newToken));

        return $this->redirect($this->generateUrl('dashboard'));
    } catch (CustomUserMessageAuthenticationException $e) {
        $error = $e->getMessage();
    }

    return $this->render('user/login.twig', [
        'error'         => $error,
        'last_username' => $request->request->get('_username'),
    ]);
}