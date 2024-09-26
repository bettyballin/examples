
$stmt = $pdo->prepare("INSERT INTO posts (code) VALUES (:code)");
$stmt->bindParam(':code', $code);
$stmt->execute();

