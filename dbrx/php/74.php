use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;

public function onTerminate(PostResponseEvent $event)
{
    // Get User From Token Storage.
    if (null !== ($token = $this->tokenStorage->getToken()) 
        && null !== ($user = $token->getUser()) 
        && $user instanceof UserInterface) {
        // Log Out The User Here. 
        $this->tokenStorage->setToken(null);
        $event->getResponse()->headers->clearCookie('PHPSESSID');
    }
}