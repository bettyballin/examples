
$stmt = $this->dbh->prepare("SELECT * FROM posts");
$stmt->execute();
$results = $stmt->fetchAll();

foreach ($
