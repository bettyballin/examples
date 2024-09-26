<?php

// Assuming you are using Doctrine and have the necessary classes and configurations set up

use App\Entity\User; // Replace with your actual User entity namespace
use Doctrine\ORM\EntityManagerInterface;

class YourClass {
    private $entityManager;

    public function __construct(EntityManagerInterface $entityManager) {
        $this->entityManager = $entityManager;
    }

    public function yourMethod($username) {
        $username = strtoupper($username); // Make sure $username is uppercase

        $query = $this->entityManager
            ->getRepository(User::class)
            ->createQueryBuilder('u')
            ->where("UPPER(u.email) LIKE :pattern")
            ->setParameter('pattern', "%{$username}%")
            ->getQuery()
            ->getOneOrNullResult();

        return $query;
    }
}

// Example usage
$entityManager = // Get your entity manager instance
$yourClass = new YourClass($entityManager);
$username = 'example';
$result = $yourClass->yourMethod($username);
var_dump($result);