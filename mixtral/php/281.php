<?php

class User implements AdvancedUserInterface
{
    private static $availableRoles = ['ADMIN', 'USER', 'MODERATOR']; // Define available roles

    private $roles;

    public function getRoles()
    {
        return array_unique($this->roles);
    }

    /**
     * @param string[] $roles
     */
    public function setRoles(array $roles)
    {
        // Ensure that the roles are always an array
        if (!is_array($roles)) {
            throw new InvalidArgumentException('$roles must be of type "string[]"');
        }

        foreach ($roles as &$role) {
            $role = strtoupper(trim($role));

            // Check that the role is valid
            if (!in_array($role, self::$availableRoles)) {
                throw new InvalidArgumentException("Role \"$role\" does not exist.");
            }
        }

        $this->roles = array_unique(array_values($roles));
    }
}

// Usage
$user = new User();
$user->setRoles(['admin', 'user']);
print_r($user->getRoles());