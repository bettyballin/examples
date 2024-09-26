<?php
$dsn = 'mysql:host=localhost;dbname=test';
$username = 'root';
$password = '';

$pdo = new PDO($dsn, $username, $password);
$pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

$stmt = $pdo->prepare("insert into foo set id = ?; insert into foo set id = ?");
$stmt->execute([1, 2]);