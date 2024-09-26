use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/account")
 */
class AccountController extends Controller
{
    /**
     * @Route("/", name="account_area")
     */
    public function accountArea()
    {
        return $this->render('account/index.html.twig');
    }
}