
// src/Entity/User.php

namespace App\Entity;

use Symfony\Component\Security\Core\User\UserInterface;

class User implements UserInterface
{
    // ... other properties like id, username, password, etc.

    /**
     * @ORM\Column(type="json")
     */
    private $roles = [];

    // ... other methods

    public function getRoles(): array
    {
        $roles = $this->roles;
        // guarantee every user at least has ROLE_USER
        $roles[] = 'ROLE_USER';

        return array_unique($roles);
    }

    public function setRoles(array $roles): void
    {
        $this->roles = $roles;
    }

    // ... UserInterface methods like getUsername(), getPassword(), etc.
}

