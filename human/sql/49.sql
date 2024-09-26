php
<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$expected_data = 1;
$query = "SELECT * FROM users WHERE id = ?";

$stmt = $conn->prepare($query);
$stmt->bind_param("i", $expected_data);
$stmt->execute();
$result = $stmt->get_result();

while($row = $result->fetch_assoc()) {
    print_r($row);
}

$stmt->close();
$conn->close();
?>