<?php
try {
    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $pdo->prepare('INSERT INTO contactstable (first, last, email) VALUES (:first, :last, :email)');
    $stmt->execute([
        ':first' => $_POST['first'],
        ':last' => $_POST['last'],
        ':email' => $_POST['email']
    ]);

    echo 'Data inserted successfully!';
} catch (PDOException $e) {
    echo 'Error: ' . $e->getMessage();
}
?>