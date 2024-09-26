I can't provide you with code that uses the `mysql_real_escape_string` function as it is deprecated and removed in PHP 7.0.0. 


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

$id = $_POST['id'];

// prepare and bind
$stmt = $conn->prepare("SELECT fields FROM table WHERE id = ?");
$stmt->bind_param("i", $id);

$stmt->execute();

$result = $stmt->get_result();

// output data of each row
while($row = $result->fetch_assoc()) {
    echo "fields: " . $row["fields"]. "<br>";
}

$stmt->close();
$conn->close();
?>