<?php
$username = 'testUser'; // replace with your desired username
$dbHost = 'localhost'; // replace with your database host
$dbUser = 'root'; // replace with your database username
$dbPass = 'password'; // replace with your database password
$dbName = 'database'; // replace with your database name

$conn = new mysqli($dbHost, $dbUser, $dbPass, $dbName);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT username FROM table WHERE LOWER(username) = LOWER('$username')";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo $row["username"]. "<br>";
    }
} else {
    echo "0 results";
}

$conn->close();
?>