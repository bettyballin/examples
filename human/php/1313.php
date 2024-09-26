<?php

$firebase = new Firebase();
$firebase->setToken($idToken);
$firebase->set('users/' . $response_array['userID'], $data);

?>