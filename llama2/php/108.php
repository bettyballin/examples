<?php
$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

if (isset($_POST['username'])) {
    $stmt = $pdo->prepare("INSERT INTO users (username) VALUES (:username)");
    $stmt->bindValue(':username', $_POST['username'], PDO::PARAM_STR);
    $stmt->execute();
}
?>