try {
    if (!$user) {
        throw new AuthenticationException('User does not exist.');
    }

    $ssoUser = $this->userProvider->loadUser($user);

    return new PreAuthenticatedToken(
        $ssoUser, $user, $providerKey, $ssoUser->getRoles()
    );
} catch (AuthenticationException $e) {
    // handle the exception
}