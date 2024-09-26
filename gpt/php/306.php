
   // Assuming $pdo is a valid PDO connection object
   $stmt = $pdo->prepare("UPDATE customers SET name = :name WHERE id = :id");
   $stmt->bindParam(':name', $name, PDO::PARAM_STR);
   $stmt->bindParam(':id', $id, PDO::PARAM_INT);
   $stmt->execute();
   
