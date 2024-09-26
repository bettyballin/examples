This is not PHP code, it appears to be a YAML configuration file for Symfony. However, I can help you convert it to PHP code that uses the Symfony Firewall component:


use Symfony\Component\Security\Core\Authentication\AuthenticationTrustResolverInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\Security;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Guard\GuardAuthenticatorHandler;
use Symfony\Component\Security\Http\Authentication\AuthenticationFailureHandlerInterface;
use Symfony\Component\Security\Http\Authentication\AuthenticationSuccessHandlerInterface;
use Symfony\Component\Security\Http\Firewall\AbstractAuthenticationListener;
use Symfony\Component\Security\Http\Firewall\ListenerInterface;
use Lexik\Bundle\JWTAuthenticationBundle\Encoder\JWTEncoder;
use Lexik\Bundle\JWTAuthenticationBundle\TokenExtractor\TokenExtractorInterface;

class FirewallConfig
{
    private $customerProvider;
    private $dealerProvider;
    private $tokenStorage;
    private $authenticationTrustResolver;
    private $authorizationChecker;
    private $guardAuthenticatorHandler;
    private $jwtEncoder;
    private $tokenExtractor;

    public function __construct(
        UserProviderInterface $customerProvider,
        UserProviderInterface $dealerProvider,
        TokenStorageInterface $tokenStorage,
        AuthenticationTrustResolverInterface $authenticationTrustResolver,
        AuthorizationCheckerInterface $authorizationChecker,
        GuardAuthenticatorHandler $guardAuthenticatorHandler,
        JWTEncoder $jwtEncoder,
        TokenExtractorInterface $tokenExtractor
    ) {
        $this->customerProvider = $customerProvider;
        $this->dealerProvider = $dealerProvider;
        $this->tokenStorage = $tokenStorage;
        $this->authenticationTrustResolver = $authenticationTrustResolver;
        $this->authorizationChecker = $authorizationChecker;
        $this->guardAuthenticatorHandler = $guardAuthenticatorHandler;
        $this->jwtEncoder = $jwtEncoder;
        $this->tokenExtractor = $tokenExtractor;
    }

    public function getCustomerLoginListener()
    {
        $pattern = '^/auth/login/customer';
        $stateless = true;
        $anonymous = true;
        $provider = $this->customerProvider;

        $jsonLogin = [
            'check_path' => '/auth/login/customer',
            'success_handler' => new LexikJWTAuthenticationHandler($this->jwtEncoder, $this->tokenExtractor),
            'failure_handler' => new LexikJWTAuthenticationHandler($this->jwtEncoder, $this->tokenExtractor),
        ];

        $listener = new CustomerLoginListener($pattern, $stateless, $anonymous, $provider, $jsonLogin);

        return $listener;
    }

    public function getDealerLoginListener()
    {
        $pattern = '^/auth/login/dealer';
        $stateless = true;
        $anonymous = true;
        $provider = $this->dealerProvider;

        $jsonLogin = [
            'check_path' => '/auth/login/dealer',
            'success_handler' => new LexikJWTAuthenticationHandler($this->jwtEncoder, $this->tokenExtractor),
            'failure_handler' => new LexikJWTAuthenticationHandler($this->jwtEncoder, $this->tokenExtractor),
        ];

        $listener = new DealerLoginListener($pattern, $stateless, $anonymous, $provider, $jsonLogin);

        return $listener;
    }
}

class CustomerLoginListener extends AbstractAuthenticationListener
{
    private $pattern;
    private $stateless;
    private $anonymous;
    private $provider;
    private $jsonLogin;

    public function __construct($pattern, $stateless, $anonymous, UserProviderInterface $provider, array $jsonLogin)
    {
        $this->pattern = $pattern;
        $this->stateless = $stateless;
        $this->anonymous = $anonymous;
        $this->provider = $provider;
        $this->jsonLogin = $jsonLogin;
    }

    protected function requiresAuthentication(Request $request)
    {
        if ($this->pattern !== null && preg_match($this->pattern, $request->getPathInfo())) {
            return true;
        }

        return false;
    }

    protected function attemptAuthentication(Request $request)
    {
        $username = $request->request->get('username');
        $password = $request->request->get('password');

        if (null === $username || null === $password) {
            throw new AuthenticationException('Username and password are required');
        }

        $token = new UsernamePasswordToken($username, $password, $this->provider->getName());

        return $this->guardAuthenticatorHandler->authenticate($token);
    }

    protected function onSuccess(Request $request, TokenInterface $token)
    {
        $this->jsonLogin['success_handler']->onAuthenticationSuccess($request, $token);
    }

    protected function onFailure(Request $request, AuthenticationException $exception)
    {
        $this->jsonLogin['failure_handler']->onAuthenticationFailure($request, $exception);
    }
}

class DealerLoginListener extends AbstractAuthenticationListener
{
    // same as CustomerLoginListener
}

class LexikJWTAuthenticationHandler implements AuthenticationSuccessHandlerInterface, AuthenticationFailureHandlerInterface
{
    private $jwtEncoder;
    private $tokenExtractor;

    public function __construct(JWTEncoder $jwtEncoder, TokenExtractorInterface $tokenExtractor)
    {
        $this->jwtEncoder = $jwtEncoder;
        $this->tokenExtractor = $tokenExtractor;
    }

    public function onAuthenticationSuccess(Request $request, TokenInterface $token)
    {
        $user = $token->getUser();

        if (!$user instanceof UserInterface) {
            throw new AuthenticationException('User is not an instance of UserInterface');
        }

        $jwtToken = $this->jwtEncoder->encode($user);

        $response = new Response();
        $response->setContent(json_encode(['token' => $jwtToken]));

        return $response;
    }

    public function onAuthenticationFailure(Request $request, AuthenticationException $exception)
    {
        $response = new Response();
        $response->setContent(json_encode(['error' => 'Authentication failed']));
        $response->setStatusCode(Response::HTTP_UNAUTHORIZED);

        return $response;
    }
}