public function authenticate(TokenInterface $token): Passport
{
    // Check if it's a local development environment
    if ($this->isLocalDevelopmentEnvironment()) {
        /** @var User $user */
        $user = $token->getUser();

        // Assign roles dynamically
        foreach (['ROLE_ADMIN', 'ROLE_USER'] as $role) {
            if (!$user->hasRole($role)) {
                $user->addRole($role);
            }
        }
    }

    return parent::authenticate($token);
}