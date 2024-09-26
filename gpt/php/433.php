
    $mysqli = new mysqli('your_host', 'username', 'password', 'your_db');
    $stmt = $mysqli->prepare('INSERT INTO table (column) VALUES (?)');
    $stmt->bind_param('s', $value); // 's' specifies the variable type => 'string'
    $stmt->execute();
    
