<?php

$storedHash = password_hash(hash('sha512', 'mysecretpassword', true), PASSWORD_DEFAULT);

var_dump(password_verify(hash('sha512', 'mysecretpassword', true), $storedHash));  // bool(true)
var_dump(password_verify(hash('sha512', 'wrongpassword', true), $storedHash));  // bool(false)

?>