
     $stmt = $mysqli->prepare("INSERT INTO table (column) VALUES (?)");
     $stmt->bind_param("s", $userInput); // 's' specifies the variable type => 'string'
     $stmt->execute();
     
