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

$enc_image = 'your_encrypted_image_data';

$stmt = $pdo->prepare("INSERT INTO images(enc_image) VALUES (?)");

$stmt->bindParam(1, $enc_image);

if ($stmt->execute()) {
    echo "Image stored successfully.";
} else {
    print_r($pdo->errorInfo());
}