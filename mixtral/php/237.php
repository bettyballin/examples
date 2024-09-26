$stmt = $pdo->prepare("INSERT INTO posts(code) VALUES(:code)");
$stmt->bindParam(':code', $user_input, PDO::PARAM_STR);
$stmt->execute();