
    $stmt = $pdo->prepare("INSERT INTO your_table (name, email, message) VALUES (?, ?, ?)");
    $stmt->execute([$name, $email, $message]);
    
