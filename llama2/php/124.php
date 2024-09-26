<?php
class User {
    private $password;

    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }
}

$user = new User();
$user->setPassword("mysecretpassword");

if (strlen($user->getPassword()) > 0) {
    $user->setPassword(hash('sha512', $user->getPassword()));
}

print($user->getPassword());
?>