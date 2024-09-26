
// Assuming $pdo is a PDO connection object
$something = $_POST['content'];

// Prepare the SQL statement with placeholders
$stmt = $pdo->prepare("INSERT INTO database (content) VALUES (:content)");

// Bind the user input to the placeholder
$stmt->bindParam(':content', $something);

// Execute the statement
$stmt->execute();

