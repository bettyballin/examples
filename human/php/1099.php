<?php

use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

class MyClass
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public function myMethod()
    {
        $this->denyAccessUnlessGranted('ROLE_ADMIN', null, 'Unable to access this page!');
    }

    private function denyAccessUnlessGranted($attribute, $subject = null, $message = 'Access Denied.')
    {
        if (!$this->authorizationChecker->isGranted($attribute, $subject)) {
            throw new \Symfony\Component\Security\Core\Exception\AccessDeniedException($message);
        }
    }
}

$myClass = new MyClass(new \Symfony\Component\Security\Core\Authorization\AuthorizationChecker());
$myClass->myMethod();