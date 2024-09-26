// FooSubscriber.php

namespace App;

use Symfony\Component\Security\Core\FirewallMapInterface;
use Symfony\Component\EventDispatcher\EventSubscriberInterface;

class FooSubscriber implements EventSubscriberInterface
{
    private $firewallMap;

    public function __construct(FirewallMapInterface $firewallMap)
    {
        $this->firewallMap = $firewallMap;
    }

    public static function getSubscribedEvents()
    {
        // Add your events here
        return [];
    }
}