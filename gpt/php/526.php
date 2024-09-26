
// Fetch the user's hashed password from the database
$qry = "SELECT * FROM accounts WHERE username = '$username'";
$result = // execute the query, for example, mysqli_query($connection, $qry);
$userData = // fetch the result, for example, mysqli_fetch_assoc($result);

// Now verify the password
if ($userData && password_verify($_POST['password'], $userData['password'])) {
    // Password is correct
} else
