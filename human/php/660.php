use JMS\SecurityExtraBundle\Annotation\Secure;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;

/**
 * @Route("/home", name="home") 
 * @Secure(roles="ROLE_USER")
 */
public function indexAction()
{
    // your code here
}