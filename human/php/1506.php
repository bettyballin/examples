<?php

session_start();

//check session for permission here!

$userTypeId = 1; //change this to requirements

if (isset($_SESSION['userTypeId']) && $_SESSION['userTypeId'] == $userTypeId) {
    header('Content-type: image/jpeg');
    echo file_get_contents("uploads/" . $userTypeId . "/" . $_GET['image']);
} else {
    header('HTTP/1.0 403 Forbidden');
    exit;
}