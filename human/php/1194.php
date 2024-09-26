<?php

use Doctrine\ORM\NonUniqueResultException;
use Doctrine\ORM\NoResultException;
use AppBundle\Entity\User;
use Symfony\Bridge\Doctrine\Security\User\UserLoaderInterface;
use Symfony\Component\Security\Core\Exception\UsernameNotFoundException;

class UserRepository extends EntityRepository implements UserLoaderInterface
{

    /**
     * Loads the user for the given username.
     *
     * This method must return null if the user is not found.
     *
     * @param string $username The username
     * @return null|User
     * @throws \Exception
     */
    public function loadUserByUsername($username)
    {
        $q = $this
            ->createQueryBuilder('u')
            ->select('u')
            ->leftJoin('u.phones', 'p')
            ->where('u.username = :username or u.email = :email or p.phoneNumber = :phone')
            ->setParameter('username', $username)
            ->setParameter('email', $username)
            ->setParameter('phone', $username)
            ->getQuery();
        try {
            $user = $q->getSingleResult();
        } catch (NoResultException $e) {
            throw new UsernameNotFoundException(sprintf('Unable to find an active user AppBundle:User object identified by "%s".', $username), 0, $e);
        } catch (NonUniqueResultException $ex) {
            throw new \Exception("The user you provided is not unique");
        }
        return $user;
    }
}