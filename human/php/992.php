This is not PHP code, it's a YAML configuration file, typically used in Symfony framework. However, I'll provide you with the equivalent PHP code:


use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\User\UserManagerInterface;
use Symfony\Component\Security\Core\User\UserCheckerInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\AuthenticatorInterface;
use Symfony\Component\Security\Core\Authentication\Token\PreAuthenticatedToken;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Http\Firewall\AbstractAuthenticationListener;
use Symfony\Component\Security\Http\HttpUtils;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Security\Core\SecurityContextInterface;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;

$container->setParameter('security.providers.fos_userbundle.id', 'fos_user.user_manager');

$container->setDefinition('security.firewall.main', new \Symfony\Component\Security\Http\Firewall('main', 
    new \Symfony\Component\Security\Http\Firewall\ChannelListener(),
    array(
        new \Symfony\Component\Security\Http\Firewall\ContextListener(),
        new \Symfony\Component\Security\Http\Firewall\LogoutListener(),
        new \Symfony\Component\Security\Http\Firewall\UsernamePasswordFormAuthenticationListener(
            $container->get('security.token_storage'),
            $container->get('security.authentication_manager'),
            new HttpUtils(),
            '/login',
            '/login_check',
            false,
            null
        ),
        new \Symfony\Component\Security\Http\Firewall\AnonymousAuthenticationListener($container->get('security.token_storage'))
    )
))
->addArgument(new \Symfony\Component\Security\Core\Exception\AuthenticationEntryPoint());