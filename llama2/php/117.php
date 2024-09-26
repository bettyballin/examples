<?php
session_start();

// Connect to SQLite database
$db = new SQLite3('farmer_market.db');

// Check if user is logged in
if(isset($_SESSION['email'])){
    $email = $_SESSION['email'];
}else{
    header("Location: login.php");
    exit;
}

// Retrieve farmer data from SQLite database
$stmt = $db->prepare('SELECT * FROM farmers WHERE email = :email');
$stmt->bindValue(':email', $email, SQLITE3_TEXT);
$result = $stmt->execute();

// Fetch farmer data
$farmer = $result->fetchArray(SQLITE3_ASSOC);

// Close the database connection
$db->close();

// Use farmer data as needed
print_r($farmer);
?>