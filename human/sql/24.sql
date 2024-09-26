php
<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

function escape($value) {
    global $conn;
    return $conn->real_escape_string($value);
}

$id = $_GET['id'];
$sql = "SELECT username FROM users WHERE id='" . escape($id) . "'";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo $row["username"];
    }
} else {
    echo "0 results";
}

$conn->close();
?>