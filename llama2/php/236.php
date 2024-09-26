use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Security;

class LoginController extends Controller
{
    public function loginAction(Request $request)
    {
        $security = $this->get('security');
        // ...
    }
}