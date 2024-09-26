<?php

use Symfony\Component\Security\Core\Authentication\AuthenticationManagerInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Event\AuthenticationEvent;
use Psr\Log\LoggerInterface;

class MyAuthenticationListener 
{
    private $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    public function logUserAction(AuthenticationEvent $event, $type)
    {
        // Get the user and action details
        $user = $event->getAuthenticationToken()->getUser();
        $action = $type == 'login' ? 'LOGIN' : 'LOGOUT';

        // Log the user action
        $this->logger->info(sprintf('USER: %s DO: %s AT: %s', $user, $action, (new \DateTime())->format('Y-m-d H:i:s')));
    }
}