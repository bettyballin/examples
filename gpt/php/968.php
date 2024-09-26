
$statement = $pdo->prepare("INSERT INTO table (column) VALUES (:value)");
$statement->bindValue(':value', $input, PDO::PARAM_STR);
$statement->execute();

