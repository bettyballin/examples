$stmt = $db_con->prepare("INSERT INTO `users` (email, psw) VALUES (?, ?)");

// Bind parameters
$stmt->bind_param('ss', $_POST['email'], password_hash($_POST['psw'], PASSWORD_DEFAULT));

if ($stmt->execute()) {
    // Success
} else {
    echo "Error: " . $stmt->error . "<br>" . $db_con->error;
}