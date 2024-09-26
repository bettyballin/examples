<?php
$username = 'your_username'; // replace with your actual username
$conn = new mysqli('your_host', 'your_username', 'your_password', 'your_database');

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM tbl WHERE tbl.usrname= '$username'";
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