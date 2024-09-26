use Symfony\Component\Security\Http\Event\InteractiveLoginEvent;
use App\Entity\User;

public function onInteractiveLogin(InteractiveLoginEvent $event)
{
    $user = $event->getAuthenticationToken()->getUser();

    // Check if user is instance of App\Entity\User (or whatever namespace and class name your User entity has).
    if ($user instanceof User && null !== $user->getLocale()) {
        $this->session->set('_locale', $user->getLocale());
    }
}