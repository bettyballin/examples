
// In a controller method

use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

public function indexAction(AuthorizationCheckerInterface $authorizationChecker)
{
    // Check for a specific role
    if ($authorizationChecker->isGranted('ROLE_ADMIN')) {
        // Current user has the ROLE_ADMIN role
    } else {
        // Current user does not have the ROLE_ADMIN role
    }

    // ...
}

