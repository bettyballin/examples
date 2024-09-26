<?php

function crypt_ext_des($password, $count, $salt) {
  // implementation of ext_des crypt
}

function crypt_md5($password, $salt) {
  // implementation of md5 crypt
}

function crypt_brypt($password, $salt, $cost) {
  // implementation of bcrypt crypt
}

function crypt_std_des($password, $salt) {
  // implementation of std_des crypt
}

function crypt($password, $salt)
{
  if (substr($salt,0, 1) == "_") {
     $count = substr($salt, 1, 4);
     $real_salt = substr($salt, 5, 4);
     return "_" . $count . $real_salt . crypt_ext_des($password, $count, $salt);
  }
  if(substr($salt, 0, 3) == "$1$") {
     list($ignored, $real_salt, $ignored) = explode("$", $salt);
     return "$1$" . $real_salt . "$" . crypt_md5($password, $real_salt);
  }
  if(substr($salt, 0, 4) == "$2a$") {
      $cost = substr($salt, 4, 2);
      $real_salt = substr($salt, 7, 22);
      return "$2a$" . $cost . "$" . $real_salt . crypt_brypt($password, $real_salt, $cost);
  }
  // ... SHA256 and SHA512 analogons

  // no match =&gt; STD_DES
  $real_salt = substr($salt, 0, 2);
  return $real_salt . crypt_std_des($password, $real_salt);
}

$password = 'test';
$salt = '_0000abcd';

echo crypt($password, $salt);

?>