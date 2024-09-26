<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $email = 'example@example.com';
    $hash = 'your_hash';

    $stmt = $pdo->prepare('UPDATE users SET active = 1 WHERE email = :email AND hash = :hash AND active = 0');
    $stmt->bindParam(':email', $email);
    $stmt->bindParam(':hash', $hash);
    $stmt->execute();

    echo 'Updated successfully!';
} catch (PDOException $e) {
    echo 'Error: ' . $e->getMessage();
}
?>