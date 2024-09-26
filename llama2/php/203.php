<?php

namespace Tykayn\MeluzineBundle\Services;

class UserDataService
{
    public function getUserData($user)
    {
        return array(
            'id' => $user->getId(),
            // other user data that you need for encoding
        );
    }
}

// Example usage:
$user = new \stdClass();
$user->id = 1;

$service = new UserDataService();
$data = $service->getUserData($user);

print_r($data);