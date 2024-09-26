<?php

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\Listener\AuthenticationListenerInterface;

class AdminToMainAuthenticator implements AuthenticationListenerInterface
{
    private $mainFirewallAuthenticator;

    public function __construct(UserLoginAuthenticator $mainFirewallAuthenticator)
    {
        $this->mainFirewallAuthenticator = $mainFirewallAuthenticator;
    }

    public function handleAuthentication(TokenInterface $token)
    {
        // Call the main firewall authenticator
        $this->mainFirewallAuthenticator->authenticate($token);
    }
}