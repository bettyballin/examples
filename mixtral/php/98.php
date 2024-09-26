<?php
$dsn = 'mysql:host=localhost;dbname=test';
$user = 'your_username';
$pass = 'your_password';

try {
    $pdo = new PDO($dsn, $user, $pass);

    // Prepare the statement
    $stmt = $pdo->prepare("INSERT INTO table (column1, column2) VALUES(:value1, :value2)");

    // Bind parameters
    $stmt->bindParam(':value1', $_POST['input_field_name']);
    $stmt->bindParam(':value2', $_POST['another_input_field_name'], PDO::PARAM_INT);

    // Execute the statement
    $stmt->execute();
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
}
?>