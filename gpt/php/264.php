
try {
    $dbh = new PDO('mysql:host=localhost;dbname=DB;port=3306', 'USER', 'SECRET', array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
    // Other code...
} catch (PDOException $e) {
    // Log the error without sensitive details and provide a generic error message to the user
    error_log($e->getMessage());
    die('A database error occurred. Please try again later.');
}

