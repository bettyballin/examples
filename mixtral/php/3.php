$stmt = $pdo->prepare('SELECT * FROM products WHERE product_id = :productId');

// Bind the parameter
$stmt->bindParam(':productId', $_GET['id'], PDO::PARAM_INT);

// Execute
$stmt->execute();