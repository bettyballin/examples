<?php
// Configuration
$username = 'your_username';
$password = 'your_password';
$host = 'your_host';
$dbname = 'your_database';

// Create connection
$conn = new mysqli($host, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$data = 'your_username';

$sql = sprintf("SELECT * FROM tbl WHERE tbl.usrname='%s'", mysqli_real_escape_string($conn, $data));

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