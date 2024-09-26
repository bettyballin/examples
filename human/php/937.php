class SecurityContext
{
    private $voters;

    public function __construct(array $voters)
    {
        $this->voters = $voters;
    }

    public function isGranted($action, $object)
    {
        foreach ($this->voters as $voter) {
            if (!$voter->supportsClass(get_class($object))) {
                continue;
            }

            if (!$voter->supportsAttribute($action)) {
                continue;
            }

            $answer = $voter->vote($action, $object);
            if ($answer === VoterInterface::ACCESS_GRANTED) {
                return true;
            } elseif ($answer === VoterInterface::ACCESS_DENIED) {
                return false;
            }
        }

        return false;
    }
}

interface VoterInterface
{
    const ACCESS_GRANTED = 1;
    const ACCESS_DENIED = -1;
    const ACCESS_ABSTAIN = 0;

    public function supportsClass($class);
    public function supportsAttribute($attribute);
    public function vote($action, $object);
}