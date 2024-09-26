public function findUserByEmail(string $email): ?User
{
    return $this->createQueryBuilder('user')
        ->addSelect('user_info')
        ->leftJoin('user.info', 'user_info')
        ->andWhere('user.email = :email')
        ->setParameter('email', $email)
        ->getQuery()
        ->getOneOrNullResult();
}