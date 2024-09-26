
// User registers with username and password; assume they're already validated
$password_entered = 'user_password'; // The password the user entered
$options = [
    'cost' => 12, // the cost parameter
];
$password_hash = password_hash($password_entered, PASSWORD_BCRYPT, $options);

// Store $password_hash in the database against the user record
$PDO = new PDO('mysql:host=localhost;dbname=myDatabase', $db_username, $db_password);
$statement = $PDO->prepare('INSERT INTO users (username, password) VALUES (:username, :password)');
$statement->execute([
    ':username' => $username_entered,
    ':password' => $password_hash,
]);

