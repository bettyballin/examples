<?php
$password = "your_password_here";
$salt = substr(str_replace('+', '.', base64_encode(call_user_func_array('pack', array_merge(array('H14N'), explode('.', uniqid('', true)))).pack('N2', mt_rand(), mt_rand()))), 0, 22);
$hash = crypt($password, '$2a$10$'.$salt.'$');
print($hash);
?>