
try {
    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');
    // Set the PDO error mode to exception
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Prepare the update statement
    $stmt = $pdo->prepare('UPDATE table SET field = MD5(:variable) WHERE id = 1');

    // Bind the value to the placeholder
    $stmt->bindParam(':
