<?php
class User {
    private $roles = [];

    public function addRole($role) {
        $this->roles[] = $role;
    }

    public function getRoles() {
        return $this->roles;
    }
}

$user = new User();
$user->addRole('ROLE_DRIVER');
$user->addRole('ROLE_OLD_DRIVER');

print_r($user->getRoles());
?>