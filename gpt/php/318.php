
require_once('../inc/db/dbc.php');

// Connect to database using MySQLi
$mysqli = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

// Check for errors
if ($mysqli->connect_error) {
    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);
}

// Prepare the statement to prevent SQL injection
$stmt = $mysqli->prepare("SELECT uU
