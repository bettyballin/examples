use Symfony\Component\Security\Http\Authenticator\Passport\Badge\UserBadge;
use Symfony\Component\Security\Core\User\UserRepositoryInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class UsernameOrEmailCaseInsensitiveBadge extends UserBadge
{
    public function __construct(string $username)
    {
        parent::__construct($username);

        // Store the username in lower case
        $this->identifier = strtolower($username);
    }

    /**
     * {@inheritdoc}
     */
    protected function getProviderKey(): string
    {
        return 'main';
    }

    public function authenticate(UserRepositoryInterface $userRepository): UserInterface
    {
        // Your authentication logic here
    }
}