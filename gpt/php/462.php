
// Assuming $pdo is a PDO connection object
$stmt = $pdo->prepare("INSERT INTO table_name (column_name) VALUES (:value)");
$stmt->
