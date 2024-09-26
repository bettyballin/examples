Here is the executable PHP code:



use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use FOS\RestBundle\Controller\AbstractFOSRestController;
use Symfony\Component\Routing\Annotation\Route;

class YourApiController extends AbstractFOSRestController
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }

    /**
     * @Route("/api/your-endpoint", name="app_user_get")
     */
    public function getUserAction()
    {
        if (!$this->isGranted('IS_AUTHENTICATED_FULLY', 'main')) {
            throw $this->createAccessDeniedException();
        }

        // ...

        return new \Symfony\Component\HttpFoundation\Response('Hello, World!');
    }
}