
// Assuming $pdo is a PDO object connected to your database
$stmt = $pdo->prepare("SELECT * FROM products WHERE product_id = :product_id");

// Bind the parameter to the query
$stmt->bindParam(':product_id', $productId, PDO::PARAM_INT);

// Sanitize input as an integer
$productId = filter_var($_GET['id'], FILTER_SANITIZE_NUMBER_INT);

// Execute the prepared statement
