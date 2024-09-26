
// Initialize variables for the WHERE clause and ORDER BY
$whereConditions = [];
$parameters = [];
$orderBy = "";

// If a search query is provided
if ($query_research_str) {
    $whereConditions[] = "user_name LIKE :search";
    $parameters[':search'] = '%' . $query_research_str . '%';
}

// If order direction option selected
if ($order_dir && $order_by) {
    // Ensure that the order direction is either 'ASC' or 'DESC' to prevent SQL injection
    $order_dir = strtoupper($order_dir) === 'ASC' ? 'ASC' : 'DESC';
    // Sanitize $order_by if necessary, e.g., against a list of allowed column names
    $orderBy = " ORDER BY $order_by $order_dir";
}

// Construct the base query
$query = "SELECT * FROM your_table";
if (!empty($
