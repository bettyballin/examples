<?php

class PasswordValidator
{
    private $jelszo;

    public function __construct($jelszo)
    {
        $this->jelszo = $jelszo;
    }

    public function validatePassword($password)
    {
        return \Yii::$app->security->validatePassword($this->jelszo, $password);
    }
}

$validator = new PasswordValidator('existing_user_password');
$passwordIsValid = $validator->validatePassword('input_password');
var_dump($passwordIsValid);

$hash = \Yii::$app->getSecurity()->generatePasswordHash('new_user_password');
var_dump($hash);


Note: Make sure you have the Yii framework installed and configured properly for this code to work.