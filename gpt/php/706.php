
public function vote(TokenInterface $token, $subject, array $attributes)
{
    // Check if $subject is an object and if the voter supports the class
    if (!is_object($subject) || !$this->supportsClass(get_class($subject))) {
        return self::ACCESS_ABSTAIN;
    }

    // ... rest of your code
}

