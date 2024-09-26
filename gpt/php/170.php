
// Assuming $pdo is a PDO instance connected to a MySQL database.
$stmt = $pdo->prepare("INSERT INTO your_table (name, tel, email, headline, text, price) VALUES (:name, :tel, :email, :headline, :text, :price)");

$stmt->bindParam(':name', $name);
$stmt->bindParam(':tel', $tel);
$stmt->bindParam(':email', $email);
$stmt->bindParam(':headline', $headline);
$stmt->bindParam(':text', $text);
$stmt->bindParam(':price', $price);

// Validate and sanitize your inputs here
$name = filter_input(INPUT_POST, 'name
