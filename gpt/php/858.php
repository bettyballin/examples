
namespace AppBundle\Security;

use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\Exception\UsernameNotFoundException;
use AppBundle\Entity\User;
use Doctrine\ORM\EntityManagerInterface;

class PhoneUserProvider implements
