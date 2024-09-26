<?php

class User {
    private $roles = array();

    public function addRole($role) {
        if (strpos($role, 'ROLE_') === 0) {
            $this->roles[] = $role;
        } else {
            throw new Exception("Role name should begin with 'ROLE_'");
        }
    }

    public function getRoles() {
        return $this->roles;
    }
}

$user = new User();
$user->addRole('ROLE_NEWUSER');

print_r($user->getRoles());

?>