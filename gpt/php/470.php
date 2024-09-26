
$mysqli = new mysqli("localhost", "user", "password", "database");

// Prepare the SQL statement with placeholders
$stmt = $mysqli->prepare("INSERT INTO your_table (column1, column2) VALUES (?, ?)");

// Bind the user input to the placeholders
$stmt
