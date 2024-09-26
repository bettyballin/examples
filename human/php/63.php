<?php
$servername = "localhost";
$username = "your_username";
$password = "your_password";
$dbname = "your_database";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$userId = 1;
$username = "johnDoe";
$hash = "your_hash";

// Insert query
$query = "INSERT INTO users VALUES({$userId}, '{$username}', '{$hash}')";
$conn->query($query);

// Select query
$query = "SELECT hash FROM users WHERE userId = {$userId}";
$result = $conn->query($query);
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "hash: " . $row["hash"]. "<br>";
    }
} else {
    echo "0 results";
}

// Update query
$query = "UPDATE users SET hash = '{$hash}' WHERE userId = {$userId}";
$conn->query($query);

$conn->close();
?>