This is not PHP code, it's a YAML configuration snippet, likely for Symfony framework. However, I'll provide a PHP code that achieves similar functionality:


use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationCredentialsNotFoundException;

$securedRoutes = [
    '/logout' => ['IS_AUTHENTICATED_ANONYMOUSLY'],
];

$path = '/logout';
$roles = $securedRoutes[$path];

if (isset($roles)) {
    try {
        $authorizationChecker = $this->get('security.authorization_checker');
        if (!$authorizationChecker->isGranted($roles[0])) {
            throw new AuthenticationCredentialsNotFoundException('Access denied');
        }
    } catch (AuthenticationCredentialsNotFoundException $e) {
        // Handle the exception
    }
}