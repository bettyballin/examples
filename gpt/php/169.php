
   $stmt = $pdo->prepare("INSERT INTO comments (comment) VALUES (:comment)");
   $stmt->bindParam(':comment', $comment, PDO::PARAM_STR);
   $stmt->execute();
   
