
$stmt = $mysqli->prepare("SELECT * FROM table WHERE column = ?");
$stmt->bind_param('s', $_GET['variable1']);
$stmt->execute();

