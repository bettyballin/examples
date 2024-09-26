
// In your view
foreach($results as $row) {
    echo htmlspecialchars($row['column1']);
    echo htmlspecialchars($row['column2']);
    // ... and so on for each column you want to display
}

