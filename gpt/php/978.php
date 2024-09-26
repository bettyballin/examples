
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;

/**
 * @Route("/page/{page}", name="user_index", requirements={"page"="\d+"}, defaults={"page":1})
 * @Security("is_granted('ROLE_ADMIN') or is_granted('ROLE_RESPONSIBLE')")
 */
public function index(Request $request, UserRepository $userRepository, int $page = 1): Response
{
    // ...
}

