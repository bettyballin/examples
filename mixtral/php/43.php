I can't execute this code as it is incomplete and has several syntax errors. However, I can provide a corrected version of the code:


$stmt = $mysqli->prepare("INSERT INTO users (username, password) VALUES (?, ?)");

// Bind the parameters
$stmt->bind_param('ss', $_POST['user'], md5($_POST['pass']));

if ($stmt->execute()) {
    echo "New user created successfully";
} else {
    die("Error: ". $mysqli->error);
}

// Close the statement
$stmt->close();