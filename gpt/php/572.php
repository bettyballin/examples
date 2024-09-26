
$stmt = $mysqli->prepare("INSERT INTO table_name (email) VALUES (?)");
$stmt->bind_param("s", $email); // "s"
