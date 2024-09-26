<?php

class User {
    private $password;

    public function getPassword() {
        return $this->password;
    }

    public function setPassword($password) {
        $this->password = $password;
    }

    /**
     * via object's event handler
     */
    public function preSave() {
        if (strlen($this->getPassword()) > 0) {
            $this->setPassword(hash('sha512', $this->getPassword()));
        }
    }
}

// example usage:
$user = new User();
$user->setPassword('mysecretpassword');
$user->preSave();
echo $user->getPassword();

?>