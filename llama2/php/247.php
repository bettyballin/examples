<?php

// Assuming Yii framework is installed and configured
require_once('yii.php');

// onBeginRequest event
$session = Yii::app()->session;
$token = generateUniqueToken();
$session['csrf_token'] = $token;

// in your form
echo '<form method="post">';
echo '<input type="hidden" name="csrf_token" value="'.$token.'">';
echo '<input type="submit">';
echo '</form>';

// when receiving a request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (!Yii::app()->request->isAjaxRequest && isset($_POST['csrf_token']) && $_POST['csrf_token'] === $session['csrf_token']) {
        // Do stuff
        echo "Request is valid";
    } else {
        die("CSRF attack detected");
    }
}

// generateUniqueToken function
function generateUniqueToken() {
    return sha1(Yii::app()->user->id . Yii::app()->session->sessionID);
}