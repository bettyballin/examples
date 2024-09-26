<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$query = 'SELECT * FROM users WHERE name=:name';
$bindings = array('name'=>'something');

$stmt = $pdo->prepare($query);
$stmt->execute($bindings);

$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
print_r($result);
?>