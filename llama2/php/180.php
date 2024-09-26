<?php

require_once('Yii.php');
require_once('Util.php');

$token = 'your_token_here';
$server = 'your_server_here';

if (Yii::app()->user->validateToken($token)) {
    // Check if the user has permission to modify the server
    $canModify = Util::checkServerPower($server);
}

?>