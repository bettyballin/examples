<?php

use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;
use Symfony\Component\Security\Core\Authorization\AuthorizationChecker;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;

class MyVoter implements VoterInterface
{
    private $authorizationChecker;

    public function __construct(AuthorizationChecker $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public function vote(TokenInterface $token, $subject, array $attributes)
    {
        // Check if the user has the required role or permission
        if ($this->authorizationChecker->isGranted('ROLE_COMPANY_MANAGER')) {
            return VoterInterface::ACCESS_GRANTED;
        }

        // If not check the user's roles and permissions
        $user = $token->getUser();
        $roles = $user->getRoles();

        foreach ($roles as $role) {
            if ($this->authorizationChecker->isGranted($role)) {
                return VoterInterface::ACCESS_GRANTED;
            }
        }

        // If the user doesn't have any of the required roles or permissions return false
        return VoterInterface::ACCESS_DENIED;
    }
}