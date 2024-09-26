public function vote(TokenInterface $token, $object, array $attributes)
{
    if (!$object || !($object instanceof AppBundle\Entity\User\Associate)) {
        return self::ACCESS_ABSTAIN;
    }

    // call the parent method
    return parent::vote($token, $object, $attributes);
}