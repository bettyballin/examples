<?php

try {
    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

    $stmt = $pdo->prepare('INSERT INTO comments (comment) VALUES (?)');

    $escaped_input = htmlspecialchars($_POST['userComment'], ENT_QUOTES, 'UTF-8');

    $stmt->bindParam(1, $escaped_input);

    if ($stmt->execute()) {
        echo "New comment added successfully";
    } else {
        echo "Error: " . $pdo->errorInfo()[2];
    }
} catch (PDOException $e) {
    echo "Error: " . $e->getMessage();
}

?>