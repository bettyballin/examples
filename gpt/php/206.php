
// Connect to the database using mysqli or PDO (mysql_* functions are deprecated)
$username = mysqli_real_escape_string($connection, $username); // Prevent SQL injection

// Convert both input and stored username to lowercase for comparison
$query = "SELECT username FROM user_table WHERE LOWER(username) = LOWER('$username')";

$result = mysqli_query($connection, $query);

if (mysqli_num_rows($result) > 0) {
    die("Duplicated usernames can't be saved, this username exists.");
} else {
    // Proceed with the registration
}

