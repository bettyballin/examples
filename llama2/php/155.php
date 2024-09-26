<?php

$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

function updateUser($updateData) {
    global $pdo;

    $fields = '';
    foreach ($updateData as $field => $value) {
        if ($field != 'id') {
            $fields .= $field . ' = :' . $field . ', ';
        }
    }
    $fields = rtrim($fields, ', ');

    $stmt = $pdo->prepare('UPDATE users SET ' . $fields . ' WHERE id = :id');

    foreach ($updateData as $field => $value) {
        $stmt->bindValue(':'.$field, $value);
    }

    $stmt->execute();
}

$updateData = [
    'id' => 1,
    'name' => 'John Doe',
    'email' => 'johndoe@example.com',
];

updateUser($updateData);

?>