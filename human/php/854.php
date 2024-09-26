use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

$container->get('security.authorization_checker')->isGranted('IS_AUTHENTICATED_ANONYMOUSLY', $request->getPathInfo());