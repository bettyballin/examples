<?php
include('Net/SSH2.php');

$ssh = new Net_SSH2('your_remote_server_ip', 22);
$ssh->login('your_username', 'your_password');

$tunnel = $ssh->getTunnel(3306, 'localhost', 3306);

$mysqli = new mysqli('127.0.0.1', 'your_database_user', 'your_database_pass', 'your_database_name', 3306);

// use $mysqli to execute queries
?>