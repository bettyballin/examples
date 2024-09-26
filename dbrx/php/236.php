use Symfony\Component\Security\Core\Authorization\AuthorizationChecker;
use Symfony\Component\Security\Core\Authorization\Expression\Expression;

$authorizationChecker = new AuthorizationChecker($this->get('security.context'));
if ($authorizationChecker->isGranted(new Expression("has_role('ROLE_ADMIN')"))) {
    // ...
}