use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManagerInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class AccessController
{
    private $tokenStorage;
    private $accessDecisionManager;

    public function __construct(TokenStorageInterface $tokenStorage, AccessDecisionManagerInterface $accessDecisionManager)
    {
        $this->tokenStorage = $tokenStorage;
        $this->accessDecisionManager = $accessDecisionManager;
    }

    public function accessControl(Request $request)
    {
        $accessControlConfig = [
            [
                'path' => '^/healthcheck',
                'roles' => ['IS_AUTHENTICATED_ANONYMOUSLY'],
                'port' => 8080,
            ],
            [
                'path' => '^/healthcheck',
                'roles' => ['ROLE_ADMIN'],
                'port' => 80,
            ],
        ];

        foreach ($accessControlConfig as $config) {
            if ($request->getPathInfo() === $config['path'] && $request->getPort() === $config['port']) {
                $token = $this->tokenStorage->getToken();
                if (!$this->accessDecisionManager->decide($token, $config['roles'])) {
                    throw new AccessDeniedException();
                }
            }
        }
    }
}