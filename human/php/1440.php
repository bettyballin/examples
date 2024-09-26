public function onAuthenticationSuccess(Request $request, TokenInterface $token, $providerKey)
{
    $user = $token->getUser();
    if ($user instanceof Employe) {
        // Do one thing
    } elseif ($user instanceof Client) {
        // Do other thing
    }
}