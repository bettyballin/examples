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

$name = 'John Doe';

$statement = $pdo->prepare('SELECT * FROM customers WHERE name = :name');
$statement->execute(array('name' => $name));

foreach ($statement as $row) {
    print_r($row);
}
?>