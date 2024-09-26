
try {
    // PDO connection code here
    $pdo = new PDO($dsn, $user, $pass);
} catch (PDOException $e) {
    // Log generic error message
    error_log('Connection failed: ' . $e->getMessage());
    // Optionally, log the detailed error message to a secure location
    // ...
    // Display a user-friendly message without sensitive details
    die('An error occurred. Please try again later.');
}

