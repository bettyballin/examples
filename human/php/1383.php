This is not PHP code, it's a YAML configuration file for Symfony's security component. However, I can provide you with the equivalent PHP code that can be used to configure the security component programmatically:


use Symfony\Component\Security\Core\Authentication\AuthenticationProviderManager;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorage;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManager;
use Symfony\Component\Security\Core\Authorization\AuthorizationChecker;
use Symfony\Component\Security\Core\Authorization\Voter\AuthenticatedVoter;
use Symfony\Component\Security\Core\Authorization\Voter\RoleVoter;
use Symfony\Component\Security\Core\Authorization\Voter\RoleHierarchyVoter;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\Exception\LogicException;
use Symfony\Component\Security\Core\User\UserChecker;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Guard\GuardAuthenticatorHandler;
use Symfony\Component\Security\Guard\Provider\GuardAuthenticationProvider;
use Symfony\Component\Security\Http\AccessMap;
use Symfony\Component\Security\Http\Authentication\AnonymousAuthenticationListener;
use Symfony\Component\Security\Http\Authentication\FormLoginAuthenticator;
use Symfony\Component\Security\Http\Authentication\GuardAuthenticationListener;
use Symfony\Component\Security\Http\Authentication\LogoutListener;
use Symfony\Component\Security\Http\Firewall;
use Symfony\Component\Security\Http\FirewallMap;
use Symfony\Component\Security\Http\FirewallMapInterface;
use Symfony\Component\Security\Http\Firewall\ExceptionListener;
use Symfony\Component\Security\Http\SecurityListener;

$container = new ContainerBuilder();

$container->register('security.firewall.map', FirewallMap::class)
    ->addMethodCall('add', array(
        '^/(_(profiler|wdt)|css|images|js)/',
        array(
            new AnonymousAuthenticationListener(),
        ),
    ));

$container->register('security.firewall.map', FirewallMap::class)
    ->addMethodCall('add', array(
        '^/admin(.*?)/',
        array(
            new GuardAuthenticationListener(
                new GuardAuthenticatorHandler(
                    array(
                        new App\Security\AdminLoginAuthenticator(),
                    ),
                    new AuthenticationProviderManager(array(
                        new GuardAuthenticationProvider(
                            new UserProviderInterface(),
                            new UserChecker(),
                            'admin_login',
                            'admin_login',
                        ),
                    )),
                    new TokenStorage(),
                ),
            ),
            new LogoutListener(
                new SecurityLogoutHandler(),
                'admin_logout',
                'admin_login',
            ),
        ),
    ));

$container->register('security.firewall.map', FirewallMap::class)
    ->addMethodCall('add', array(
        '^/',
        array(
            new AnonymousAuthenticationListener(),
            new GuardAuthenticationListener(
                new GuardAuthenticatorHandler(
                    array(
                        new App\Security\UserLoginAuthenticator(),
                    ),
                    new AuthenticationProviderManager(array(
                        new GuardAuthenticationProvider(
                            new UserProviderInterface(),
                            new UserChecker(),
                            'security_logout',
                        ),
                    )),
                    new TokenStorage(),
                ),
            ),
        ),
    ));