
   $stmt = $pdo->prepare("SELECT * FROM users WHERE username = :username");
   $stmt->execute(['username' => $username]);
   
