
// Assuming $pdo is your PDO connection
$stmt = $pdo->prepare("INSERT INTO users (username) VALUES (:username)");
$stmt->bindParam(':username', $_POST['username']);
$stmt->execute();

