<?php

namespace AppBundle\Security;

use Symfony\Bridge\Doctrine\Security\User\UserLoaderInterface;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class UserLoader implements UserLoaderInterface
{
    private $entityManager;

    public function __construct(EntityManagerInterface $entityManager)
    {
        $this->entityManager = $entityManager;
    }

    public function loadUserByUsername($username)
    {
        $user = $this->entityManager->getRepository('AppBundle:User')
            ->findOneBy(['username' => $username]);

        if (!$user) {
            throw new \Exception('User not found');
        }

        return $user;
    }
}