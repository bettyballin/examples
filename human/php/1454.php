<?php

use Symfony\Bundle\SecurityBundle\Security;
use Symfony\Component\EventDispatcher\EventSubscriberInterface;
use Symfony\Component\HttpKernel\Event\RequestEvent;
use Symfony\Component\HttpKernel\KernelEvents;

class FooSubscriber implements EventSubscriberInterface
{

    private $firewallMap;

    public function __construct(Security\FirewallMap $firewallMap)
    {
        $this->firewallMap = $firewallMap;
    }

    public static function getSubscribedEvents(): array
    {
        return [KernelEvents::REQUEST => 'onKernelRequest'];
    }

    public function onKernelRequest(RequestEvent $event): void
    {
        if (!$event->isMasterRequest()) {
            return;
        }

        $config = $this->firewallMap->getFirewallConfig($event->getRequest());

        if (!$config instanceof Security\FirewallConfig || (!$config->isSecurityEnabled() || $config->allowsAnonymous())) {
            return;
        }
    }
}