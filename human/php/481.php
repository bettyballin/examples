use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Http\Logout\LogoutHandlerInterface;

class CustomLogoutHandler implements LogoutHandlerInterface
{
    public function logout(Request $request, Response $response, TokenInterface $token)
    {
        // Custom logout logic here
    }
}


yml
firewalls:
    main: 
        logout:
            path:   /logout
            target: /
            success_handler: App\CustomLogoutHandler