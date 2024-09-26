<?php

$salt = "salt";
$password = "password";
$res_5a = crypt($password, '$6$rounds=5000$'.$salt.'$');
$res_25 = crypt($password, '$6$rounds=2500$' . $salt . '$');
$res_5b = crypt($res_25, '$6$rounds=2500$'.$salt.'$');

var_dump($password,$res_5a,$res_25,$res_5b);

?>