
   $stmt = $pdo->prepare("SELECT username FROM User WHERE username = :username AND password = :password");
   $stmt->execute(array(':username' => $usernameGiven, ':password' => $passwordGiven));
   
