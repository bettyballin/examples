public function loadUserByIdentifier(string $identifier): UserInterface
{
    $user = $this->em->createQueryBuilder('u')
        ->select('u')
        ->from(YourUser::class, 'u')
        ->where('LOWER(u.username) = :username')
        ->setParameter('username', strtolower($identifier))
        ->setMaxResults(1)
        ->getQuery()
        ->getOneOrNullResult();

    if (!$user instanceof YourUser) {
        throw new UserNotFoundException('No user found for ' . $identifier);
    }

    return $user;
}