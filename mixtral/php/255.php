use Symfony\Component\HttpFoundation\Response;

class RegistrationController extends Controller
{
    public function registerAction()
    {
        // Option 1: Redirect to registration route
        return new Response($this->redirectToRoute('registration'));

        // Option 2: Render registration template
        // return $this->render('security/register.html.twig', array());
    }
}