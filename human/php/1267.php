This is not PHP code, it's a YAML configuration file for Symfony framework. Here is the equivalent PHP code:


use Symfony\Component\Security\Core\Authorization\Voter\RoleHierarchyVoter;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManager;
use Symfony\Component\Security\Core\Authentication\AuthenticationProviderManager;
use Symfony\Component\Security\Core\Authentication\Provider\DaoAuthenticationProvider;
use Symfony\Component\Security\Core\Encoder\PlaintextPasswordEncoder;
use Symfony\Component\Security\Core\User\UserChecker;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\Role\Role;
use Symfony\Component\Security\Core\SecurityContext;
use Symfony\Component\Security\Core\Util\SecureRandom;
use Symfony\Component\Security\Http\AccessMap;
use Symfony\Component\Security\Http\Authentication\SimplePreAuthenticator;
use Symfony\Component\Security\Http\Firewall;
use Symfony\Component\Security\Http\FirewallMap;
use Symfony\Component\Security\Http\SecurityListener;

// Define the firewalls
$firewalls = array(
    'app_resources' => array(
        'pattern' => '^/(_(profiler|wdt)|css|images|js)/',
        'security' => false,
    ),
    'main' => array(
        'pattern' => '^/',
        'http_basic' => array(
            'provider' => 'fos_userbundle',
        ),
    ),
);

// Define the access control rules
$accessControl = array(
    array('path' => '^/admin/', 'role' => 'ROLE_ADMIN'),
    array('path' => '^/', 'role' => 'ROLE_DEBUGGING'),
);

// Define the role hierarchy
$roleHierarchy = array(
    'ROLE_ADMIN' => array('ROLE_USER', 'ROLE_DEBUGGING', 'ROLE_SONATA_ADMIN'),
    'ROLE_SUPER_ADMIN' => array('ROLE_ADMIN'),
);

// Create the security context
$securityContext = new SecurityContext($roleHierarchy, new AccessDecisionManager());

// Create the firewall map
$firewallMap = new FirewallMap();

// Add the firewalls to the map
foreach ($firewalls as $name => $firewall) {
    $firewallMap->add($name, new Firewall($firewall['pattern'], $firewall['security']));
}

// Create the authentication manager
$authenticationManager = new AuthenticationProviderManager();

// Add the authentication providers to the manager
$authenticationManager->addProvider(new DaoAuthenticationProvider(new UserProviderInterface(), new PlaintextPasswordEncoder()));

// Create the access map
$accessMap = new AccessMap();

// Add the access control rules to the map
foreach ($accessControl as $rule) {
    $accessMap->add($rule['path'], $rule['role']);
}

// Create the security listener
$securityListener = new SecurityListener($securityContext, $firewallMap, $authenticationManager, $accessMap);

// Add the security listener to the event dispatcher
// Note: This should be done in the boot method of your kernel
// $dispatcher->addListener(KernelEvents::REQUEST, array($securityListener, 'handle'));