php
<?php
$link = mysqli_connect("localhost", "username", "password", "database");

if (!$link) {
    die("Connection failed: " . mysqli_connect_error());
}

$email = "example@example.com";
$email = mysqli_real_escape_string($link, $email);

$sql = "SELECT * FROM users WHERE email = '$email'";
$result = mysqli_query($link, $sql);

if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
        echo "id: " . $row["id"]. " - Name: " . $row["name"]. " " . $row["email"]. "<br>";
    }
} else {
    echo "0 results";
}

mysqli_close($link);
?>