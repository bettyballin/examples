
// Assuming $db is your database connection

// Prepare the SQL statement with placeholders
$stmt = $db->prepare("INSERT INTO users (login, password) VALUES (?, ?)");

// Bind the variables to the placeholders
$stmt->bind_param("ss", $login, $password);

// Trim the input
$login = trim($login);
$password = trim($password);

// Execute the prepared statement
$stmt->execute();

// Check for success/failure
if ($stmt->affected_rows > 0) {
    echo "Record successfully inserted.";
} else {
    echo "Error: " . $stmt->error;
}

// Close the statement
$stmt->close();

