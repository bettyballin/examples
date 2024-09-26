This is not PHP code, it's a YAML configuration file for Symfony security settings. However, I can provide you with an example of how to create a Symfony security configuration in PHP:


use Symfony\Component\Security\Core\Authorization\Voter\RoleVoter;
use Symfony\Component\Security\Core\Authorization\Voter\AuthenticatedVoter;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManager;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserChecker;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\Authentication\AuthenticationProviderManager;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManagerInterface;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;

// Firewall configuration
$firewalls = array(
    'main' => array(
        'pattern' => '^/',
        'form_login' => array(
            'login_path' => '/account/login',
            'check_path' => '/account/login_check',
        ),
        'logout' => array(
            'path' => '/account/logout',
        ),
        'anonymous' => true,
    ),
    'dev' => array(
        'pattern' => '^/(_(profiler|wdt)|css|images|js)/',
        'security' => false,
    ),
);

// Access control configuration
$accessControl = array(
    array('path' => '^/account/login$', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'),
    array('path' => '^/account/register', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'),
    array('path' => '^/movie/', 'role' => 'ROLE_USER'),
    array('path' => '^/resetting', 'role' => 'IS_AUTHENTICATED_ANONYMOUSLY'),
    array('path' => '^/admin/', 'role' => 'ROLE_ADMIN'),
);