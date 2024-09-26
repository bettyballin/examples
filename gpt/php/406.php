
// Create a prepared statement
if ($stmt = $mysqli->prepare("SELECT * FROM userdata WHERE UserName=? AND Password=PASSWORD(?)")) {

    // Bind your variables to replace the ? marks in the SQL statement
    $stmt->bind_param("ss", $user, $pwd);

    // Set your variables
    $user = $_POST['user'];
    $pwd = $_POST['pwd'];

    // Execute the query
    $stmt->execute();

    // Fetch your results, etc...
    $result = $stmt->get_result();

    // Rest of your code...

    // Close the statement
    $stmt->close();
}

