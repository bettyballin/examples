
   // Using mysqli
   $stmt = $mysqli->prepare("SELECT * FROM users WHERE email = ?");
   $stmt->bind_param("s", $email); // 's' specifies the variable type => 'string'
   $stmt->execute();
   $result = $stmt->get_result();

   // Using PDO
   $stmt = $pdo->prepare("SELECT * FROM users WHERE email = ?");
   $stmt->execute([$email]);
   $result = $stmt->fetchAll();
   
