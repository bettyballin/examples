
   // Unsafe way
   $query = "SELECT * FROM users WHERE username = '" . $_GET['username'] . "'";

   // Safe way using PDO
   $stmt = $pdo->prepare('SELECT * FROM users WHERE username = :username');
   $stmt->execute(['username' => $_GET['username']]);
   
