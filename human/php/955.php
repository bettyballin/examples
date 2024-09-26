<?php
$password = $_POST['password'];
$userData = array(array('passwordhash' => '$2y$10$randomHashValue'));

if(password_verify($password, $userData[0]['passwordhash'])) { 
    echo "Good password";
} else {
    echo "Bad password";
}