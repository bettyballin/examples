use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

/**
 * @Route("/", name="index")
 */
public function indexAction(AuthorizationCheckerInterface $authorizationChecker)
{
    if ($authorizationChecker->isGranted('IS_AUTHENTICATED_ANONYMOUSLY')) {
        // do something
    }
}