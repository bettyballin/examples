use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Security\Core\Annotation\Security;

/**
 * @Route("/calculator", name="calculator")
 */
class CalculatorController extends Controller
{
    /**
     * Display the form.
     *
     * This method is accessible for all users (GET).
     *
     * @param Request $request
     *
     * @return Response
     */
    public function displayCalculatorAction(Request $request)
    {
        // Create and handle the form
        $form = $this->createForm(CalculatorType::class);

        return $this->render('MyBundle:Pages:calculator.html.twig', array('form' => $form->createView()));
    }

    /**
     * @Security("has_role('ROLE_USER')")
     *
     * Process the submitted form (POST).
     *
     * This method is only accessible for logged-in users with ROLE_USER role.
     *
     * @param Request $request
     *
     * @return Response
     */
    public function processCalculatorAction(Request $request)
    {
        // Create and handle the form
        $form = $this->createForm(CalculatorType::class);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()){
            //blablabla

            return new Response('Form processed successfully');
        }

        throw new \Exception("Invalid request");
    }
}