use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authorization\Voter\AbstractVoter;

class YourVoter extends AbstractVoter
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }

    protected function isGranted($attribute, $subject): bool
    {
        $token = $this->tokenStorage->getToken();
        if (!$token instanceof TokenInterface) {
            return false;
        }

        $user = $token->getUser();
        if ($user && in_array('ROLE_COMPANY_MANAGER', $user->getRoles())) {
            return true;
        }

        // ...
    }

    protected function supports($attribute, $subject): bool
    {
        // ...
    }
}