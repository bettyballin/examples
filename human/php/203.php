<?php
$password = 'ilovjenny84';
$salt = 'SHAKY SHARKY 333'; 
$password_hash = sha1($salt.sha1($password.$salt)); 
echo $password_hash;
?>