public function findOneByUsernameOrEmail(string $username): ?User
{
    return $this->createQueryBuilder('u')
        ->where("LOWER(u.email) = :query OR LOWER(u.usernameLowercase) = :query")
        ->setParameter('query', strtolower($username))
        ->getQuery()
        ->getOneOrNullResult();
}