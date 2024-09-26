<?php

function generate_secure_token() {
    return bin2hex(random_bytes(16));
}

$token = generate_secure_token(); 
$file_name = "example.jpg";
$user_id = 123;

// Connect to database
$db = new PDO('sqlite:example.db');

// Create table if it doesn't exist
$db->exec('
    CREATE TABLE IF NOT EXISTS files (
        token TEXT PRIMARY KEY,
        file_name TEXT,
        user_id INTEGER
    );
');

// store the token, file name, and user ID in the database
$stmt = $db->prepare("INSERT INTO files (token, file_name, user_id) VALUES (:token, :file_name, :user_id)");
$stmt->bindParam(":token", $token);
$stmt->bindParam(":file_name", $file_name);
$stmt->bindParam(":user_id", $user_id);
$stmt->execute();

// delete the file
$stmt = $db->prepare("DELETE FROM files WHERE token = :token AND user_id = :user_id");
$stmt->bindParam(":token", $token);
$stmt->bindParam(":user_id", $user_id);
$stmt->execute();

// Close database connection
$db = null;

?>