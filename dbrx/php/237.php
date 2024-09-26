use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Expression\ExpressionLanguage;

$container = new ContainerInterface();
$authorizationChecker = $container->get('security.authorization_checker');
$expressionLanguage = $container->get('security.expression_language');

if ($authorizationChecker->isGranted($expressionLanguage->evaluate("has_role('ROLE_ADMIN')"))) {
    // ...
}