
// Get USER ID of person
$userID = $_GET['userID'];

// Prepare the SQL statement using placeholders
$sql = "SELECT * FROM persons WHERE id = :userID";

// Prepare the statement
$stmt = $conn->prepare($sql);

// Bind the integer value of userID to the placeholder
$stmt->bindValue(':userID', (int)$userID, PDO::PARAM_INT);

// Execute the prepared statement
$stmt->execute();

// Fetch results
while ($r = $stmt->fetch(PDO::FETCH_LAZY)) {
    echo '';
    echo '' . htmlspecialchars($r['date_submitted']) . ''; // Use htmlspecialchars to prevent XSS
    // MORE STUFF
    echo '';
}

