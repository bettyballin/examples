<?php
session_start();

$username = 'johnDoe';
$userId = 1;

$_SESSION['user'] = $username;
// Or
$_SESSION['id_user'] = $userId;

if(isset($_SESSION['user'])) {
    echo "User exists";
} else{
   echo "User does not exist";
}
?>