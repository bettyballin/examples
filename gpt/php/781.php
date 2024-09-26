
// Assuming $db_con is a valid mysqli connection

$email = $_POST['email'];
$psw = $_POST['psw'];

// Prepare a statement
$query = $db_con->prepare("INSERT INTO `users` (`email`, `psw`) VALUES (?, ?)");

// Bind variables to the prepared statement as parameters
$query->bind_param("ss", $email, $psw);

// Execute the query
$query->execute();

// Check for errors
