Here is the executable PHP code:


namespace AppBundle\Security\VoterProvider;

use Symfony\Component\DependencyInjection\ContainerAwareInterface;
use Symfony\Component\DependencyInjection\ContainerInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\VoterInterface;

class VoterProvider implements VoterInterface, ContainerAwareInterface
{
    private $container;

    public function setContainer(ContainerInterface $container = null)
    {
        $this->container = $container;
    }

    public function vote(TokenInterface $token, $subject, array $attributes)
    {
        // Your voting logic here
    }

    public function supportsAttribute($attribute)
    {
        // Your attribute support logic here
    }

    public function supportsClass($class)
    {
        // Your class support logic here
    }
}