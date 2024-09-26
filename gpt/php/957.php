
$stmt = $pdo->prepare("SELECT * FROM column_name WHERE id = :id");
$stmt->bindParam(':id', $id, PDO::PARAM_INT);
$stmt->execute();

