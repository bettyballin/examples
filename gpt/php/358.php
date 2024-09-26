
     $stmt = $pdo->prepare("INSERT INTO users (username, email) VALUES (:username, :email)");
     $stmt->bindParam(':
