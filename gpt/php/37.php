
// Connect to the database
$mysqli = new mysqli("localhost", "your_username", "your_password", "your_database");

// Check connection
if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}

// Prepare the SQL statement
$stmt = $mysqli->prepare("SELECT * FROM mytable WHERE userid = ? AND category = ? ORDER BY id DESC");

// Bind parameters to the statement
$stmt->bind_param("ss", $userid, $category);

// Get the parameters from the URL
$userid = $_GET['userid'];
$category = $_GET['category'];

// Execute the prepared statement
$stmt->execute();

// Get the result of the query
$result = $stmt->get_result();

// Fetch the data
while ($row = $result->fetch_assoc()) {
    // Process your result (e.g., echo or store in an array)
