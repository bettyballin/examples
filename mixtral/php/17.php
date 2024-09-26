use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;

public function indexAction(Request $request)
{
    // Checks whether the current session has an authenticated user
    if ($this->get('security.authorization_checker')->isGranted('IS_AUTHENTICATED_REMEMBERED')) {
        return new RedirectResponse($this->generateUrl('dashboard', array(), UrlGeneratorInterface::ABSOLUTE_PATH));

    } else {

       // Render login form
       return $this->render('login.html.twig');
   }
}