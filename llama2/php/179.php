<?php

// Assuming this is a Yii framework application
require_once 'yii/framework/yii.php';

// Initialize the application
$app = Yii::createApplication('CWebApplication');

// Assuming the CHtml class is part of the application
CHtml::ajaxButton("Insert New Player", array('addPermission', 'server' => $server->serverID, 'token' => Yii::app()->session['token']), array('success'=>'refresh'));

// Run the application
$app->run();

?>