<?php
$db = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$email = 'user@example.com';

$is_user = $db->prepare('SELECT count(userid) FROM users WHERE email = ?');
$is_user->execute([$email]);
$is_user = $is_user->fetchColumn();

var_dump($is_user);
?>