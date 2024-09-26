<?php
try {
    $pdo = new PDO('sqlsrv:Server=localhost;Database=mydatabase', 'plainTextUserOMG!', 'plainTextPasswordOMG!');
} catch (PDOException $e) {
    error_log("Failed to connect to the database. Error message: " . $e->getMessage());
}
?>