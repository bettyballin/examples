public function vote(TokenInterface $token, $object, array $attributes)
{
    // Add this check to ensure that object is not null and it's actually an instance of a class
    if (!$object || !is_a($object, 'stdClass')) {
        return self::ACCESS_ABSTAIN;
    }

    if (!$this->supportsClass(get_class($object))) {
         return self::ACCESS_ABSTAIN;
     }

   // ...
}