use Sensio\Bundle\FrameworkExtraBundle\Configuration\Security;

/**
 * @Security("has_role('ROLE_ADMIN')")
 */
class MyController
{
    /**
     * @Security("has_role('ROLE_USER')")
     */
    public function myAction()
    {
        // action code here
    }
}