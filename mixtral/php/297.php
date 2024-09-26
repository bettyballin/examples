class AdminVoter extends AbstractVoter
{
    const ACCEPT_PR = 'ACCEPT_PR';

    protected function supports($attribute, $subject): bool
    {
        return in_array($attribute, [self::ACCEPT_PR])
            && ($subject instanceof PullRequest);
    }

    /**
     * @param string         $attribute
     * @param mixed          $subject
     *
     * @return bool
     */
    protected function voteOnAttribute(string $attribute, $subject): bool
    {
        // implementation of voteOnAttribute method
    }
}