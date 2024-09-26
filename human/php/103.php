$password_cleartext = 'your_password_here';
$password_hash = password_hash($password_cleartext, PASSWORD_DEFAULT);

// Store password_hash in database
// Assuming you have a database connection established and a query function
// This is a simplified example and actual implementation may vary

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO users (username, password) VALUES ('your_username', '$password_hash')";
$conn->query($sql);

$conn->close();