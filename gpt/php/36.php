
$db = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');

// Prepare the SQL statement with placeholders
$stmt = $db->prepare('SELECT * FROM users WHERE
