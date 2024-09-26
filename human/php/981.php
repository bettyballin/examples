<?php

use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Exception\UnsupportedUserException;
use Symfony\Component\Security\Core\Exception\UsernameNotFoundException;

class RequestUsersProvider implements UserProviderInterface
{
    private $class;
    private $property;

    public function __construct($class, $property)
    {
        $this->class = $class;
        $this->property = $property;
    }

    public function loadUserByUsername($username)
    {
        $user = $this->findUser($username);

        if (!$user) {
            throw new UsernameNotFoundException(sprintf('User "%s" not found.', $username));
        }

        return $user;
    }

    public function refreshUser(UserInterface $user)
    {
        if (!$user instanceof $this->class) {
            throw new UnsupportedUserException(sprintf('Instances of "%s" are not supported.', get_class($user)));
        }

        return $this->loadUserByUsername($user->getUsername());
    }

    public function supportsClass($class)
    {
        return $class === $this->class;
    }

    private function findUser($username)
    {
        // Implement your logic to find the user based on the username
        // This can be a database query or any other way to find the user
        // For this example, we assume an EntityManager and a UserRepository
        $entityManager = // get the entity manager;
        $userRepository = $entityManager->getRepository($this->class);

        return $userRepository->findOneBy(array($this->property => $username));
    }
}