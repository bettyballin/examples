<?php

use Doctrine\ORM\EntityManagerInterface;
use App\Entity\User;

class YourClassName
{
    private $entityManager;

    public function __construct(EntityManagerInterface $entityManager)
    {
        $this->entityManager = $entityManager;
    }

    public function yourFunctionName($newUsername, $acl)
    {
        $userRepository = $this->entityManager->getRepository(User::class);
        $user = $userRepository->findOneByUsername($newUsername);

        if ($user) {
            $user->setSecurityIdentifier($acl);
            $this->entityManager->flush();
        }
    }
}