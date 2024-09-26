<?php

use Symfony\Component\Security\Core\Exception\UnsupportedUserException;
use Adh\Security\User;

class UnsupportedUserExceptionTest
{
    public function testUnsupportedUserException()
    {
        $user = new stdClass();

        try {
            $this->checkUser($user);
        } catch (UnsupportedUserException $e) {
            echo $e->getMessage() . "\n";
        }
    }

    private function checkUser($user)
    {
        if (!$user instanceof User) {
            throw new UnsupportedUserException(sprintf('Instances of "%s" are not supported.', get_class($user)));
        }
    }
}

$test = new UnsupportedUserExceptionTest();
$test->testUnsupportedUserException();

?>