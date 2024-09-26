class UserApplicationVoter implements VoterInterface
{

  const USER_APPLICATION = 'USER_APPLICATION';

    private $doctrine;

    public function __construct(Doctrine\Bundle\DoctrineBundle\Registry $doctrine)
    {
        $this->doctrine = $doctrine;
    }

    protected function voteOnAttribute($attribute, $application, TokenInterface $token): bool
    {
        $user = $token->getUser();
        $app = $application;

        if (!$user instanceof User || !$app instanceof Application)
            return false;

        $em = $this->doctrine->getManager();

        $repoUserApplication = $em->getRepository(UserApplication::class);

        // Check user access to application
        $userApplication = $repoUserApplication->findOneBy(['user' => $user, 'application' => $app]);

        return $userApplication !== null;
    }

    public function supports($attribute, $subject): bool
    {
        if ($attribute !== self::USER_APPLICATION) {
            return false;
        }

        if (!$subject instanceof Application) {
            return false;
        }

        return true;
    }
}