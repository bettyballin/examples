
$stmt = $mysqli->prepare("SELECT * FROM column_name WHERE id = ?");
$stmt->bind_param('i', $id); // 'i' specifies the variable type is integer
$stmt->execute();

