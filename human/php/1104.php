<?php

// Create database connection
$dsn = 'mysql:host=localhost;dbname=test';
$username = 'username';
$password = 'password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

// Create tables
$pdo->exec('
    CREATE TABLE IF NOT EXISTS users (
        id INT AUTO_INCREMENT,
        username VARCHAR(255),
        PRIMARY KEY (id)
    );
');

$pdo->exec('
    CREATE TABLE IF NOT EXISTS products (
        id INT AUTO_INCREMENT,
        name VARCHAR(255),
        user_owner INT,
        PRIMARY KEY (id),
        FOREIGN KEY (user_owner) REFERENCES users(id)
    );
');

// Insert data
$pdo->exec('
    INSERT INTO users (id, username)
    VALUES (1, "Dave"), (2, "John");
');

$pdo->exec('
    INSERT INTO products (id, name, user_owner)
    VALUES (1, "Milk", 1), (2, "Cake", 2);
');

// Fetch data
$users = $pdo->query('SELECT * FROM users')->fetchAll(PDO::FETCH_ASSOC);
$products = $pdo->query('SELECT * FROM products')->fetchAll(PDO::FETCH_ASSOC);

// Print data
print_r($users);
print_r($products);