
$mysqli = new mysqli($host, $username, $password, $database);

// Prepare the SQL statement
$query = $mysqli->prepare('SELECT * FROM users WHERE id = ? AND check = ?');

// Validate and/or sanitize inputs before binding
$id = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_INT);
$check = filter_input(INPUT_POST, 'check', FILTER_VALIDATE_INT);

// Check if the inputs are valid, handle the error if not
if ($id === false || $
