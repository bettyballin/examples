<?php

class User {
    private $id;
    private $roles;

    public function __construct($id, array $roles) {
        $this->id = $id;
        $this->roles = $roles;
    }

    public function getRoles() {
        return $this->roles;
    }
}

class Role {
    private $permissions;

    public function __construct($permissions) {
        $this->permissions = $permissions;
    }

    public function getPermissions() {
        return $this->permissions;
    }
}

function getUserById($id) {
    // Simulating a database query
    $user = new User(1, [
        new Role(3), // Role with permissions 1 and 2
        new Role(5)  // Role with permissions 1 and 4
    ]);
    return $user;
}

$userId = 1;
$user = getUserById($userId);
$roles = $user->getRoles();
$permissions = array_reduce($roles, function ($carry, $role) {
    return $carry | $role->getPermissions();
}, 0);

if ($permissions & 1) { 
    echo "User has permission to add news";
} else {
    echo "User does not have permission to add news";
}