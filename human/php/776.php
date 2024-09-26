<?php
$dsn = 'mysql:host=localhost;dbname=mydatabase';
$username = 'myusername';
$password = 'mypassword';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$a = 'valuea';
$b = 'valueb';
$c = 'valuec';

$sql = "INSERT INTO mytable (columna, columnb, columnc) VALUES (?, ?, ?)";
$stmt = $pdo->prepare($sql);
$stmt->execute([$a, $b, $c]);