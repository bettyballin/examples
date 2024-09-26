
public function updateDatabase($value) {
    // Assuming $pdo is your PDO connection
    $stmt = $pdo->prepare('UPDATE myTable SET myColumn = :value WHERE foo = "bar"');
    $stmt->bindParam(':value', $value);
    $stmt->execute();
}

