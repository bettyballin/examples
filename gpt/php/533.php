
$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');
$statement = $pdo->prepare("SELECT * FROM users WHERE username = :username");
$statement->bindParam(':username', $username, PDO::PARAM_STR);
$statement->execute();

$results = $statement->fetchAll();

