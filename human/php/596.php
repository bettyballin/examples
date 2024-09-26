<?php

// get and check certificate
$get = stream_context_create(array("ssl" => array("capture_peer_cert" => TRUE)));
$read = stream_socket_client("ssl://www.google.com:443", $errno, $errstr, 30, STREAM_CLIENT_CONNECT, $get);
$cert = stream_context_get_params($read);

$valid = ($cert["options"]["ssl"]["peer_certificate"] != NULL) ? true : false;

// save validity in database or somewhere else accessible
$db = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');
$stmt = $db->prepare('INSERT INTO your_table (is_valid) VALUES (:valid)');
$stmt->bindParam(':valid', $valid);
$stmt->execute();

?>