<?php

use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use FOS\UserBundle\Model\UserManagerInterface;

class UserController
{
    private $container;

    public function __construct(ContainerInterface $container)
    {
        $this->container = $container;
    }

    public function deleteUser(UserInterface $user)
    {
        if (!$this->isGranted('delete', $user)) {
            throw new AccessDeniedException();
        }

        // delete user
        $this->container->get('fos_user.user_manager')->deleteUser($user);
    }

    private function isGranted($attribute, $subject = null)
    {
        return $this->container->get('security.authorization_checker')->isGranted($attribute, $subject);
    }
}