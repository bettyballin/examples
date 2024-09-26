use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\HttpFoundation\Response;

class AdminController
{
    public function adminAction(AuthorizationCheckerInterface $authChecker)
    {
        if (!$authChecker->isGranted('ROLE_ADMIN')) {
            throw new AccessDeniedException();
        }

        return new Response('Admin page!');
    }
}