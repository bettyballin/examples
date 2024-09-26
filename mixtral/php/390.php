<?php
$db_name = 'your_database_name.db'; // replace with your database name
$password = 'your_password'; // replace with your password
$Mail = 'your_email@example.com'; // replace with your email
$Quantity = 'your_quantity'; // replace with your quantity
$Name = 'your_name'; // replace with your name

$db = new SQLite3($db_name);

// Prepare the INSERT statement
$stmt = $db->prepare("INSERT INTO PURCHASE (quantity, name, password, mail) VALUES (?, ?, ?, ?)");

// Bind parameters and execute
if (!$stmt->bindValue(1, $Quantity, SQLITE3_TEXT)) {
    throw new Exception($db->lastErrorMsg());
}

if (!$stmt->bindValue(2, $Name, SQLITE3_TEXT)) {
    throw new Exception($db->lastErrorMsg());
}

// You should not store passwords in plain text. Use a hashing algorithm like bcrypt or Argon2
$hashedPassword = password_hash($password, PASSWORD_DEFAULT);

if (!$stmt->bindValue(3, $hashedPassword)) {
    throw new Exception($db->lastErrorMsg());
}

// You should validate the email before inserting it into your database
if (!filter_var($Mail, FILTER_VALIDATE_EMAIL)) {
    // Handle invalid mail
} else {
    if (!$stmt->bindValue(4, $Mail)) {
        throw new Exception($db->lastErrorMsg());
    }
}

// Execute the statement
$result = $stmt->execute();

// Close the database connection
$db->close();
?>