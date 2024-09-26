use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\HttpFoundation\Request;

class YourController extends Controller
{
    public function changeRoleAction(Request $request, TokenStorageInterface $tokenStorage)
    {
        // your code here
    }
}