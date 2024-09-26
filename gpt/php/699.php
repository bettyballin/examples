
// Use these namespaces
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

// Inject the AuthorizationCheckerInterface in your controller or service constructor
private $authorizationChecker;

public function __construct(AuthorizationCheckerInterface $authorizationChecker) {
    $this->authorizationChecker = $authorizationChecker;
}

public function yourMethod() {
    if ($this->authorizationChecker->isGranted('ROLE_ADMIN')) {
        echo "Enter";
    } else {
        echo "Do not enter";
    }
}

