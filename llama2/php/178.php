<?php

$token = Yii::app()->user->generateToken();
Yii::app()->session['token'] = $token;

?>