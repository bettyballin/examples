namespace App\EventListener;

use App\Entity\User;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Security\Core\AuthenticationEvents;
use Symfony\Component\Security\Core\Event\AuthenticationEvent;

class LoginListener
{
    private $urlGenerator;

    public function __construct(UrlGeneratorInterface $urlGenerator)
    {
        $this->urlGenerator = $urlGenerator;
    }

    public function onInteractiveLogin(AuthenticationEvent $event): void
    {
        // Get the User entity.
        /** @var User */
        $user = $event->getAuthenticatedToken()->getUser();

        if ($user && true === $user->isForcePasswordChange()) {
            $response = new RedirectResponse($this->urlGenerator->generate('force_password_change'));

            // Stop the propagation of login process
            $event->setResponse($response);

            return;
        }
    }
}