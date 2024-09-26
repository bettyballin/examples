
// Securely hash the password using bcrypt without manually adding a salt
$pass = password_hash($_POST['pass'], PASSWORD_BCRYPT);

