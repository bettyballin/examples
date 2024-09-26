<?php
$uid = filter_var($_POST['uid'], FILTER_SANITIZE_NUMBER_INT);
$nonce = filter_var($_POST['nonce'], FILTER_SANITIZE_STRING);
$request_timestamp = filter_var($_POST['time'], FILTER_SANITIZE_STRING);
?>