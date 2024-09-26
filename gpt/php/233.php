
$db = new PDO('mysql:host=localhost;dbname=yourDB', 'username', 'password');

// Prepare statement
$stmt = $db->prepare('SELECT * FROM users WHERE username = :username AND password = :password');

// Bind parameters
$stmt->bindParam(':username', $_POST['loginUserName']);
$stmt->bindParam(':password', $_POST['loginPassword']);

// Execute the query
$stmt->execute();

// Fetch result
$user = $stmt->fetch(PDO::FETCH_ASSOC);

