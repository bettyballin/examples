<?php

namespace Acme\TestBundle\Service;

use Symfony\Component\Security\Core\Encoder\PasswordEncoderInterface;

class Sha256Salted implements PasswordEncoderInterface
{

    public function encodePassword($raw, $salt)
    {
        return hash('sha256', $salt . $raw); 
    }

    public function isPasswordValid($encoded, $raw, $salt)
    {
        return $encoded === $this->encodePassword($raw, $salt);
    }

}

// Example usage
$encoder = new Sha256Salted();
$rawPassword = 'mysecretpassword';
$salt = 'mysalt';

$encodedPassword = $encoder->encodePassword($rawPassword, $salt);

echo "Encoded password: " . $encodedPassword . "\n";

$isPasswordValid = $encoder->isPasswordValid($encodedPassword, $rawPassword, $salt);

echo "Is password valid? " . ($isPasswordValid ? 'Yes' : 'No') . "\n";

?>