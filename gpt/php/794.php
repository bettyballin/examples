
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

class SomeService
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public
