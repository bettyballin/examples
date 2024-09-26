<?php
$conn = mysqli_connect("localhost", "username", "password", "database");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$user = mysqli_real_escape_string($conn, $_POST['user']);
$pwd = mysqli_real_escape_string($conn, $_POST['pwd']);

$query = "SELECT * FROM userdata WHERE UserName='$user' AND Password=PASSWORD('$pwd')";
$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
        echo $row["UserName"] . " - " . $row["Password"]. "<br>";
    }
} else {
    echo "0 results";
}

mysqli_close($conn);
?>