<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

$pdo = new PDO($dsn, $username, $password);

$name = 'John Doe';

$stmt = $pdo->prepare('SELECT * FROM users WHERE name = :name');
$stmt->execute(array('name' => $name));

foreach ($stmt as $row) {
    print_r($row);
}
?>