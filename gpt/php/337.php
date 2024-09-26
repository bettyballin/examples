
$stmt = $pdo->prepare("SELECT * FROM table WHERE column = :value");
$stmt->bindParam(':value', $_GET['variable1'], PDO::PARAM_STR);
$stmt->execute();

