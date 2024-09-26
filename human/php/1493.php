<?php
session_start();

$token = $_POST['token'];
$ses_token = $_SESSION['token'];

if($ses_token == $token){ 
    $return = ['message' => 'valid token',  'status' => true];
} else {
    $return = ['message' => 'invalid token',  'status' => false];
}

echo json_encode($return);
?>