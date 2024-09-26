<?php

$db = new PDO('sqlite:mydatabase.sqlite3');

// Prepare a statement for querying users
$stmt = $db->prepare("SELECT * FROM users WHERE name = :name");

// Bind the user input as a parameter (this escapes any special characters)
$name = $_POST['username'];
$stmt->bindParam(':name', $name);

// Execute the query with the bound parameters
$stmt->execute();

$userlist = Array();
foreach ($stmt->fetchAll() as $user) {
    $userlist[] = $user['name'];
}

print_r($userlist);

?>