public function findUserByEmail(string $email): ?User
{
    return $this->createQueryBuilder('user')
        ->addSelect('user_info')
        ->leftJoin('user.info', 'user_info', null, 'user_info.user_id = user.id')
        ->where('user.email = :email')
        ->setParameter('email', $email)
        ->getQuery()
        ->getOneOrNullResult();
}