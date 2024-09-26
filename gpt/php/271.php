
public function updateDatabase($value) {
    // Assuming $mysqli is your database connection
    $stmt = $mysqli->prepare('UPDATE myTable SET myColumn = ? WHERE foo = "bar"');
    $stmt->bind_param('s', $value);
    $stmt->execute();
}

