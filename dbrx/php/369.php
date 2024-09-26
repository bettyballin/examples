namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\ControllerEvent;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Core\User\UserInterface;

class UserEnabledListener
{
    private $security;

    public function __construct(Security $security)
    {
        $this->security = $security;
    }

    public function onController(ControllerEvent $event)
    {
        $user = $this->security->getUser();

        if (!$user instanceof UserInterface) {
            return;
        }

        // Check user is enabled or not.
        if (false === $user->isEnabled()) {
            throw new AccessDeniedException('Account disabled');
        }
    }
}