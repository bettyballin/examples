<?php
$db = new PDO('sqlite:mydatabase.sqlite3');

// Prepare the query
$stmt = $db->prepare("SELECT * FROM users WHERE name=?");

// Bind parameters
$name = "John";
$stmt->bindParam(1, $name);

// Execute
$stmt->execute();

// Fetch results
while ($row = $stmt->fetch()) {
    echo $row['name'];
}
?>