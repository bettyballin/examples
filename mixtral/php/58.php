<?php

use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

class UserApplicationController
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public function displayApplication($application)
    {
        if (!$this->authorizationChecker->isGranted(UserApplicationVoter::USER_APPLICATION, $application)) {
            throw new AccessDeniedException();
        }

        // Display application details
        // ...
    }
}

class UserApplicationVoter
{
    const USER_APPLICATION = 'USER_APPLICATION';
}