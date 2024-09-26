
// Assuming $pdo is a PDO instance connected to the database
$secret = $_POST['secret'];
$SQL = "SELECT goodies FROM stash WHERE secret = :secret";
$stmt = $pdo->prepare($SQL
