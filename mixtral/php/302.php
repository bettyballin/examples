<?php

use Symfony\Component\Security\Core\User\InMemoryUserProvider;
use Symfony\Component\Security\Core\User\UserInterface;

$app['security.firewalls'] = [
    'admin' => [
        // ...

        $factory = new UserFactory();

        return (new InMemoryUserProvider([
            $factory->create('admin', ['ROLE_ADMIN'], 'password')
        ]));
    ]
];

class UserFactory
{
    public function create($username, array $roles, string $plainPassword): UserInterface
    {
        return new class($username, $roles, $plainPassword) implements UserInterface
        {
            private $username;
            private $roles;
            private $password;

            public function __construct($username, array $roles, string $plainPassword)
            {
                $this->username = $username;
                $this->roles = $roles;
                $this->password = $plainPassword;
            }

            /**
             * @inheritDoc
             */
            public function getRoles()
            {
                return $this->roles;
            }

            /**
             * @inheritDoc
             */
            public function getPassword()
            {
                return $this->password;
            }

            /**
             * @inheritDoc
             */
            public function getSalt()
            {
                return null;
            }

            /**
             * @inheritDoc
             */
            public function getUsername()
            {
                return $this->username;
            }

            /**
             * @inheritDoc
             */
            public function eraseCredentials(): void
            {
                $this->password = null;
            }
        };
    }
}