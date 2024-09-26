
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;

class CalculatorController extends Controller
{
    /**
     * This action handles the GET request and displays the form.
     * No security annotation is needed here, as all users can access this method.
     * 
     * @Route("/calculator", name="calculator_display", methods={"GET"})
     */
    public function displayAction()
    {
        $form = $this->createForm(CallRequestType::class, new CallRequest());

        return $this->render('MyBundle:Pages:calculator.html.twig', array('form' => $form->createView()));
    }

    /**
     * This action handles the POST request and processes the form.
     * It requires the user to have the ROLE_USER role.
     * 
     * @Route("/calculator",
