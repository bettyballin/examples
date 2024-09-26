$stmt = $pdo->prepare('INSERT INTO table (json) VALUES(:json)');

// Bind parameters

$stmt->bindParam(":json", json_encode($data), PDO::PARAM_STR);

// Execute query

if ($stmt->execute()) {
    // Success
}
else{
   // Error
}