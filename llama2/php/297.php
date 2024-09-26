<?php

class PasswordHandler
{
    private $_password;
    private $_salt;

    public function __construct($password = 'myVeryStrongPasswordThanBefore')
    {
        $this->_password = $password;
        $this->regenerateSalt();
    }

    public function regenerateSalt()
    {
        $salt = openssl_random_pseudo_bytes(32);
        $this->_salt = bin2hex($salt);
    }

    public function hashPassword()
    {
        return password_hash($this->_password, PASSWORD_DEFAULT, [
            'cost' => 14
        ]);
    }
}

$passwordHandler = new PasswordHandler();
echo $passwordHandler->hashPassword();

?>