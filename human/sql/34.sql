php
<?php
$iId = (int)"1 OR 1=1";
$sSql = "SELECT * FROM table WHERE id = $iId";

// Prevent SQL injection by using prepared statements
$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
$stmt = $pdo->prepare("SELECT * FROM table WHERE id = :id");
$stmt->bindParam(':id', $iId);
$stmt->execute();

// Fetch and print results
$results = $stmt->fetchAll();
print_r($results);
?>