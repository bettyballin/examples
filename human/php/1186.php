This is not PHP code, it's a YAML configuration file for Symfony framework. However, I can provide you with an example of how to use this configuration in a PHP file:


use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class SecurityController
{
    private $requiresChannel;

    public function __construct($requiresChannel)
    {
        $this->requiresChannel = $requiresChannel;
    }

    public function adminAction(AuthorizationCheckerInterface $authorizationChecker)
    {
        if (!$authorizationChecker->isGranted('ROLE_ADMIN')) {
            throw new AccessDeniedException();
        }

        // requires_channel logic
        if ($this->requiresChannel === 'https' && $_SERVER['REQUEST_SCHEME'] !== 'https') {
            return new Response('', 301, ['Location' => 'https://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI']]);
        }

        // admin action logic
        return new Response('Admin dashboard');
    }
}



use Symfony\Component\Config\FileLocator;
use Symfony\Component\DependencyInjection\ContainerBuilder;
use Symfony\Component\DependencyInjection\Loader\YamlFileLoader;

$configDir = __DIR__ . '/config';
$locator = new FileLocator($configDir);
$loader = new YamlFileLoader($container = new ContainerBuilder(), $locator);
$loader->load('security.yml');

$requiresChannel = $container->getParameter('requires_channel');
$securityController = new SecurityController($requiresChannel);

$authorizationChecker = // instance of AuthorizationCheckerInterface;
$response = $securityController->adminAction($authorizationChecker);