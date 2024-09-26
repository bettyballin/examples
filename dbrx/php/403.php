<?php

use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\User\EntityUserProvider;

class CaseInsensitiveEntityUserProvider extends EntityUserProvider {
    public function loadUserByIdentifier(string $identifier): UserInterface {
        // Convert identifiers to lowercase for case-insensitive comparison
        $lowercaseIdentifier = strtolower($identifier);

        return parent::loadUserByIdentifier($lowercaseIdentifier);
    }

    protected function findUser(array $criteria) {
        if (isset($criteria[$this->property])) {
            // Convert user property value to lowercase before comparing it with the identifier
            $criteria[$this->property] = strtolower($criteria[$this->property]);
        }
        
        return parent::findUser($criteria);
    }
}

// Example usage:
$userProvider = new CaseInsensitiveEntityUserProvider();
$user = $userProvider->loadUserByIdentifier('TestUser');