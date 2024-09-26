use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\HttpFoundation\Request;

class LoginController
{
    public function loginAction(Request $request, TokenStorageInterface $security)
    {
        // Your code here
    }
}