
$dbh = new PDO('mysql:host=localhost;dbname=test', $user, $pass);
$stmt = $dbh->prepare("SELECT * FROM stories WHERE showing = 1 ORDER BY cr_date DESC LIMIT 5");
$stmt->execute();
$results = $stmt->fetchAll(PDO::FETCH_ASSOC);

foreach ($results as $row) {
    $story_id = $row["id"];
    // etc...
}

