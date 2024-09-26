
$pass = $_POST['password'];
$hashedPass = password_hash($pass, PASSWORD_DEFAULT);
// Store $hashedPass in the database

