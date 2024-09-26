<?php

use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class SecurityChecker
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    /**
     * @param string $controller
     * @param UserInterface $user
     * @return bool
     * @throws AccessDeniedException
     */
    public function check($controller, UserInterface $user): bool
    {
        $reflectionClass = new \ReflectionClass($controller);
        $classAnnotations = $reflectionClass->getAnnotations();

        if (isset($classAnnotations['security']) && isset($classAnnotations['security']['roles'])) {
            $requiredRoles = $classAnnotations['security']['roles'];
            foreach ($requiredRoles as $requiredRole) {
                if ($this->authorizationChecker->isGranted($requiredRole, $user)) {
                    return true;
                }
            }
        }

        throw new AccessDeniedException();
    }
}