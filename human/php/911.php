<?php
class User {
    private $roles;

    public function setRoles(array $roles) {
        $this->roles = $roles;
    }

    public function getRoles() {
        return $this->roles;
    }
}

$user = new User();
$user->setRoles(array("ROLE_DRIVER", "ROLE_OLD_DRIVER"));
print_r($user->getRoles());
?>