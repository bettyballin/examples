Here is the executable PHP code:


// src/Security/IsLocalhostVoter.php
namespace App\Security;

use Symfony\Component\HttpFoundation\RequestStack;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\Voter\AbstractVoter;

class IsLocalhostVoter extends AbstractVoter
{
    private $requestStack;

    public function __construct(RequestStack $requestStack)
    {
        $this->requestStack = $requestStack;
    }

    protected function supports($attribute, $subject): bool
    {
        return 'IS_LOCALHOST' === $attribute && null !== $subject;
    }

    /**
     * @param string|string[] $attributes
     */
    protected function voteOnAttribute(
        $attribute,
        $subject,
        TokenInterface $token
    ): bool {

        if ($this->requestStack->getCurrentRequest()->server->get('REMOTE_ADDR') === '127.0.0.1' ||
            $this->requestStack->getCurrentRequest()->headers->get('host') == 'localhost:8000') {
            return true;
        }
        return false;
    }
}