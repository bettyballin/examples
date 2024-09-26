
// Assuming $dbconn is a valid database connection resource

// Query with placeholders
$query = 'SELECT * FROM user WHERE login=$1 AND password=md5($2)';

// Prepare the statement
if ($stmt = pg_prepare($dbconn, "", $query)) {
    // Execute the prepared statement with the user-supplied parameters
    $result = pg_execute($dbconn, "", array($_POST["user"], $_POST["password"]));

    // Check the result
    if (pg_num_rows($result) < 1) {
        die("failure");
    } else {
        // Process the successful authentication
    }
} else {
    // Handle errors in preparation
    die("Prepared statement creation failed");
}

