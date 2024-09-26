use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class MyController extends Controller 
{
    /**
     * @Security("is_granted('my_permission') or is_granted('another_permission')")
     */
    public function myAction() 
    {
        // ...
        return new Response('Hello World!');
    }
}