use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;

class PullRequestController
{
    private $authorizationChecker;

    public function __construct(AuthorizationCheckerInterface $authorizationChecker)
    {
        $this->authorizationChecker = $authorizationChecker;
    }

    public function acceptAction(PullRequest $pullRequest)
    {
        if (!$this->authorizationChecker->isGranted('accept', $pullRequest)) {
            throw new AccessDeniedException();
        }

        // ...
    }
}