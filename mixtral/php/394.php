namespace App\Security\Voter;

use Symfony\Component\HttpFoundation\RequestStack;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authorization\AccessDecisionManagerInterface;
use Symfony\Component\Security\Core\Authorization\Voter\Voter;

class IsActiveVoter extends Voter
{
    private $requestStack;

    public function __construct(RequestStack $requestStack)
    {
        $this->requestStack = $requestStack;
    }

    protected function supports(string $attribute, $subject): bool
    {
        return 'IS_ACTIVE' === $attribute && null !== ($user = $this->getUser());
    }

    protected function voteOnAttribute(string $attribute, $subject, TokenInterface $token): bool
    {
        return (bool) $this->getUser()->isActive();
    }

    private function getUser(): ?object
    {
        $request = $this->requestStack->getCurrentRequest();
        if (!$request) {
            return null;
        }

        $user = $request->getUser();
        if (!$user instanceof UserInterface) {
            return null;
        }

        return $user;
    }
}