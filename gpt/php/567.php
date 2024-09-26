
   // Using PDO
   $stmt = $pdo->prepare('SELECT * FROM table WHERE id = :id');
   $stmt->execute(['id' => $id]);
   
