
// Assuming $pdo is your PDO connection object
$stmt = $pdo->prepare("SELECT * FROM table WHERE column = :value");
$stmt->bindParam(':value', $value, PDO::PARAM_STR);
$stmt->execute();

$results = $stmt->fetchAll();

