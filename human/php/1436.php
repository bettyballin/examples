class Voter implements VoterInterface
{
    public const ACTIVE = 'active';

    protected function supports(string $attribute, $subject)
    {
        return $attribute === self::ACTIVE;
    }

    protected function voteOnAttribute(string $attribute, $subject, TokenInterface $token)
    {
        $user = $token->getUser();

        if ($user instanceof User && !$user->isActive()) {
            throw new InactiveUserException();
        }

        return true;
    }
}