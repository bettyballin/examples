
// Assuming $conn is your mysqli connection
$username = isset($_POST['username']) ? mysqli_real_escape_string($conn, $_POST['username']) : '';

