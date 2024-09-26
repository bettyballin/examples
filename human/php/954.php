<?php
$pgsql = new PDO('pgsql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$userData = $pgsql->prepare("SELECT * FROM accounts WHERE username = ?");
$userData->execute(array($_POST['username']));
$userData = $userData->fetchAll();
?>