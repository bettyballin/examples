use Symfony\Component\EventDispatcher\EventDispatcherInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;

class YourController
{
    public function index(
        Request $request, 
        UserPasswordEncoderInterface $passwordEncoder, 
        TokenStorageInterface $tokenStorage, 
        EventDispatcherInterface $eventDispatcher
    )
    {
        // Your code here
    }
}