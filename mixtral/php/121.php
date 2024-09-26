$password = 'your_password';
$salt = uniqid(mt_rand(), true);
$hashed_password = hash('sha256', $password . $salt);

// Store this hashed value along with its corresponding user's ID and the generated salt
$user_id = 1; // Replace with actual user ID
$db_connection = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');
$query = "INSERT INTO users (id, password, salt) VALUES (:id, :password, :salt)";
$statement = $db_connection->prepare($query);
$statement->bindParam(':id', $user_id);
$statement->bindParam(':password', $hashed_password);
$statement->bindParam(':salt', $salt);
$statement->execute();