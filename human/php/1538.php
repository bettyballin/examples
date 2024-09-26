<?php

use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\Authentication\Token\PreAuthenticatedToken;

class AccessTokenUserProvider implements UserProviderInterface
{
    public function loadUserByUsername($username)
    {
        // Implement logic to load user by username
    }

    public function refreshUser(UserInterface $user)
    {
        // Implement logic to refresh user
    }

    public function supportsClass($class)
    {
        // Implement logic to support class
    }
}

class AccessTokenHandler
{
    public function __construct(AccessTokenUserProvider $userProvider)
    {
        $this->userProvider = $userProvider;
    }

    public function getAccessToken(Request $request)
    {
        // Implement logic to extract access token from request
    }

    public function handleAccessToken($accessToken)
    {
        // Implement logic to handle access token
    }
}

// services.yml
services:
  app.access_token_user_provider:
    class: App\Security\AccessTokenUserProvider

// security.yml
security:
  providers:
    access_token_provider:
      id: app.access_token_user_provider
  firewalls:
    api:
      lazy: true
      provider: access_token_provider
      stateless: true
      pattern: ^/api
      access_token:
        token_extractors: header
        token_handler: App\Security\AccessTokenHandler