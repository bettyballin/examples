
    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');
    $stmt = $pdo->prepare('INSERT INTO table (column) VALUES (:value)');
    $stmt->bindParam(':value', $value, PDO::PARAM_STR);
    $stmt->execute();
    
