<?php

require __DIR__ . '/vendor/autoload.php';

use Symfony\Component\Security\Core\Authentication\Provider\ChainProvider;
use Symfony\Component\Security\Core\User\ChainUserProvider;
use Symfony\Component\Security\Core\User\InMemoryUserProvider;
use Symfony\Component\Security\Core\User\User;

// AppBundle\Services\My
namespace AppBundle\Services;

class My
{
    private $chainProvider;

    public function __construct(ChainProvider $chainProvider)
    {
        $this->chainProvider = $chainProvider;
    }

    public function loadUser($username)
    {
        return $this->chainProvider->loadUserByUsername($username);
    }
}

// Create an in-memory user provider for demonstration purposes
$userProvider = new InMemoryUserProvider([
    'admin' => new User('admin', 'admin', ['ROLE_ADMIN']),
]);

// Create a chain user provider
$chainUserProvider = new ChainUserProvider([$userProvider]);

// Create a chain authentication provider
$chainProvider = new ChainProvider([$chainUserProvider]);

// Instantiate the My class
$my = new My($chainProvider);

// Load a user
$user = $my->loadUser('admin');

print_r($user);