
$dbh = new PDO('mysql:host=' . DB_HOST . ';dbname=' . DB_NAME, DB_USERNAME, DB_PASSWORD);

$username = $_POST["username"];
$email = $_POST["email"];
// Hash the password before storing it.
$password = password_hash($_POST["password"], PASSWORD_DEFAULT);

// Use prepared statements with bound parameters to prevent SQL injection
$stmt = $dbh->prepare("INSERT INTO users (username, email, password) VALUES (:username, :email, :password)");
$stmt->bindParam(':username', $username);
$stmt->bindParam(':email', $email);
$stmt->bindParam(':password', $password);
$stmt->execute();

echo "Thank you, you are registered";

