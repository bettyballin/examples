
$statement = $mysqli->prepare("INSERT INTO table (column) VALUES (?)");
$statement->bind_param('s', $input);
$statement->execute();

