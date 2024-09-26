
    $password = $_POST['password']; // Make sure to use proper validation and sanitization
    $hash = password_hash($password, PASSWORD_DEFAULT);
    
