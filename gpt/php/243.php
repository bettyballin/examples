
    $stmt = $pdo->prepare("SELECT * FROM table WHERE id = :id");
    $stmt->bindParam(':id', $id, PDO::PARAM_INT);
    $stmt->execute();
    
