use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

// admin firewall
$adminFirewall = [
    'pattern' => '^/admin',
    'provider' => 'in_memory',
    'form_login' => [
        'check_path' => '/check_login',
        'login_path' => '/admin/login',
    ],
    'logout' => [
        'invalidate_session' => true,
        'path' => '/admin/company/logout',
        'target' => '/',
    ],
    'anonymous' => true,
];

// access control
$accessControl = [
    [
        'path' => '^/admin/login$',
        'roles' => ['IS_AUTHENTICATED_ANONYMOUSLY'],
    ],
];

// assuming a symfony container is available
$container = new \Symfony\Component\DependencyInjection\Container();

// create a new security context
$securityContext = $container->get('security.context');

// authenticate
$token = $securityContext->getToken();
if (!$token instanceof TokenInterface) {
    throw new AccessDeniedException();
}

// authorize
$voter = new \Symfony\Component\Security\Core\Authorization\Voter\RoleVoter();
$attribute = 'IS_AUTHENTICATED_ANONYMOUSLY';
if (!$voter->vote($token, null, [$attribute])) {
    throw new AccessDeniedException();
}

// execute code that requires authentication and authorization
// ...