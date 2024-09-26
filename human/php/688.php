<?php
$upc = "your_upc_value"; // replace with your UPC value
$conn = new mysqli("localhost", "username", "password", "database");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$upc = $conn->real_escape_string($upc);
$sql = "SELECT * FROM products WHERE upc = '$upc'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        print_r($row);
    }
} else {
    echo "0 results";
}
$conn->close();
?>