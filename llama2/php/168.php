$hash = password_hash($password, PASSWORD_BCRYPT);
$stmt = $pdo->prepare("INSERT INTO users (email, password) VALUES (:email, :password)");
$stmt->bindParam(':email', $email);
$stmt->bindParam(':password', $hash);
$stmt->execute();