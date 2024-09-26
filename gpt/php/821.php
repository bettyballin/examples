
try {
    // Create a new PDO instance for a SQLite database
    $db = new PDO('sqlite:/path/to/your/mydatabase.sqlite3');
    // Set PDO to throw exceptions on error
    $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    // Set PDO to not emulate prepared statements
    $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    
    // Use prepared statements to fetch user data
    $stmt = $db->prepare("SELECT * FROM users WHERE username = :username");
    $stmt->bindParam(':username', $username, PDO::PARAM_STR);
    $username = 'example_user'; // The username to search
