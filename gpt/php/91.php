
// Create a connection
$mysqli = new mysqli("localhost", "my_user", "my_password", "my_db");

// Check connection
if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

// Prepare a statement
$stmt = $mysqli->prepare("INSERT INTO users (password, username) VALUES (?, ?)");

// Bind the parameters (s for string, b for blob, i for int, etc)
$passwordHash = sha1($_POST['password']);
$username = $_POST['username'];
$stmt
