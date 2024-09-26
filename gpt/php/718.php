
// Assuming $mysqli is a MySQLi connection object
$something = $_POST['content'];

// Prepare the SQL statement with placeholders
$stmt = $mysqli->prepare("INSERT INTO database (content) VALUES (?)");

// Bind the user input to the placeholder
$stmt->bind_param('s', $something);

