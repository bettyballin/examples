<?php
$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

// Prepare the SQL statement
$stmt = $pdo->prepare("INSERT INTO posts (post) VALUES(:post)");

// Bind parameters to placeholders
$stmt->bindParam(':post', $_REQUEST['post'], PDO::PARAM_STR);

// Execute query
if ($stmt->execute()) {
    header("Location: http://istheinternetfuckingawesome.com");
} else {
   echo "Error inserting data";
}
?>