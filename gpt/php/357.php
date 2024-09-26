
     $stmt = $mysqli->prepare("INSERT INTO users (username, email) VALUES (?, ?)");
     $stmt->bind_param("ss", $username, $email);
     $stmt->execute();
     
