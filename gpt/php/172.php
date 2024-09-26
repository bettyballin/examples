
   $pdo_stmt = $pdo->prepare("SELECT * FROM architects WHERE name = :arch");
   $pdo_stmt->bindParam(":arch", $architect, PDO::PARAM_STR);
   $pdo_stmt->execute();
   
