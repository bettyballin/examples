<?php
// Configuration
$db_host = 'your_host';
$db_name = 'your_database';
$db_user = 'your_username';
$db_pass = 'your_password';
$limit = 10; // results per page

// Connect to database
$db = new PDO("mysql:host=$db_host;dbname=$db_name", $db_user, $db_pass);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

// Get input from user
$query_research_str = $_GET['research_str'] ?? null;
$order_by = $_GET['order_by'] ?? null;
$order_dir = $_GET['order_dir'] ?? null;

// Build query
$query = "SELECT * FROM users";

// If research string option selected
if ($query_research_str) {
    $whereClause = 'WHERE user_name LIKE :researchStr';
    $queryParams[':researchStr'] = '%' . $db->quote($query_research_str) . '%'; 
} else {
    $whereClause = '';
}

// If order direction option selected
if ($order_dir) {
    if (!in_array(strtolower($order_by), ['id', 'user_name'])) { 
        die('Invalid order by value');
    }
    $orderByClause = "ORDER BY $order_by $order_dir";
} else {
    $orderByClause = '';
}

$query .= "$whereClause $orderByClause";

$stmt = $db->prepare($query);
$stmt->execute($queryParams ?? []);

$total_results = $stmt->rowCount();
$total_pages = ceil($total_results / $limit); 

if (!isset($_GET['page'])) {
    $page = 1;
} else {
    if (filter_var($_GET['page'], FILTER_VALIDATE_INT) === false || intval($_GET['page']) < 0) { 
        die('Invalid page value');
    }
    $page = $_GET['page'];
}

$starting_limit = ($page - 1) * $limit;
$query .= " LIMIT $starting_limit, $limit";

$stmt = $db->prepare($query);
$stmt->execute();

while ($res = $stmt->fetch(PDO::FETCH_ASSOC)) {
    // Display results
    var_dump($res);
}