use Symfony\Component\Security\Csrf\CsrfToken;
use Symfony\Component\Security\Csrf\CsrfTokenManagerInterface;

public function __construct(UserRepository $userRepo, CsrfTokenManagerInterface $csrfTokenManager)
{
    //...
}