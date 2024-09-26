use Symfony\Component\HttpKernel\Event\GetResponseEvent;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;

public function onKernelRequest(GetResponseEvent $event, TokenStorageInterface $tokenStorage, AuthorizationCheckerInterface $authorizationChecker)
{
    if (!$event->isMasterRequest()) {
        return;
    }

    if ($tokenStorage->getToken() === null) {
        return;
    }

    if ($authorizationChecker->isGranted('ROLE_DEBUGGING')) {
        return;
    }

    $event->setResponse(new RedirectResponse('/'));
}