This is not PHP code, but rather YAML configuration for Symfony's security settings. However, I will provide a PHP code that accomplishes the same access control:


use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class AccessController
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public function loginAction()
    {
        if (!$this->authorizationChecker->isGranted('IS_AUTHENTICATED_ANONYMOUSLY')) {
            throw new AccessDeniedException();
        }
        // login action
    }

    public function gcAction()
    {
        if (!$this->authorizationChecker->isGranted('IS_AUTHENTICATED_ANONYMOUSLY')) {
            throw new AccessDeniedException();
        }
        // gc action
    }

    public function adminMaintenancePdfAction()
    {
        if (!$this->authorizationChecker->isGranted(['ROLE_USER', 'IS_AUTHENTICATED_ANONYMOUSLY'])) {
            throw new AccessDeniedException();
        }
        // admin maintenance pdf action
    }

    public function adminAction()
    {
        if (!$this->authorizationChecker->isGranted('ROLE_USER')) {
            throw new AccessDeniedException();
        }
        // admin action
    }

    public function indexAction()
    {
        if (!$this->authorizationChecker->isGranted('ROLE_USER')) {
            throw new AccessDeniedException();
        }
        // index action
    }
}