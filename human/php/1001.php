This is not PHP code, it appears to be a YAML configuration file, likely for a Symfony application. However, I can provide you with an example of how this configuration might be translated into PHP code:


use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Routing\RouterInterface;

class LogoutController
{
    private $tokenStorage;
    private $router;

    public function __construct(TokenStorageInterface $tokenStorage, RouterInterface $router)
    {
        $this->tokenStorage = $tokenStorage;
        $this->router = $router;
    }

    public function logout(Request $request)
    {
        $this->tokenStorage->setToken(null);
        $request->getSession()->invalidate();

        return new RedirectResponse($this->router->generate('homepage'));
    }
}