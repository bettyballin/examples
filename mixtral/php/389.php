$stmt = $mydatabase->prepare("SELECT * FROM mytable WHERE title LIKE ?");
$query = "%{$search}%";
$stmt->bind_param('s', $query);

// Execute the query
if ($stmt->execute()) {
    // Fetch data
    $result = $stmt->get_result();
    while($row = $result->fetch_assoc()) {
        // Process $row data
    }
} else {
    // Handle query execution error
    echo "Error executing query: " . $stmt->error;
}