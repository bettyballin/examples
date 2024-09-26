
   // Using PDO
   $stmt = $pdo->prepare("INSERT INTO feedback (user_agent, referrer) VALUES (:user_agent, :referrer)");
   $stmt->bindParam(':user_agent', $_SERVER['HTTP_USER_AGENT']);
   $stmt->bindParam(':referrer', $_SERVER['HTTP_REFERER']);
   $stmt->execute();
   
