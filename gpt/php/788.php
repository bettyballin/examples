
   // Assuming $pdo is your PDO database connection object
   $stmt = $pdo->prepare("INSERT INTO comments (comment) VALUES (:comment)");
   $stmt->bindParam(':comment', $comment, PDO::PARAM_STR);
   $comment = $_POST['comment']; // The user's input
   $stmt->execute();
   
