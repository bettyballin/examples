$link = mysqli_connect("localhost", "username", "password", "database");

if (!$link) {
    die("Connection failed: " . mysqli_connect_error());
}

$email = "example@example.com";
$email = mysqli_real_escape_string($link, $email);

mysqli_close($link);