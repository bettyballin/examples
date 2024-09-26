$ids = array('pid_b', 'pid_l', 'pid_g');
$qMarks = str_repeat('?, ', count($ids) - 1) . '?';

// THIS MY CONDITION FOR TESTING PURPOSES ONLY
$testVar = 1;

// NOW WE BUILD THE QUERY
$sqlQuery = "SELECT * FROM inventory_tbl ";
$sqlQuery .= "WHERE `consignor_record_id` IN ($qMarks)";
$sqlQuery .= ($testVar == 1 ? " AND `inventory_status` <> 'active' " : "");
$sqlQuery .= "ORDER BY `created_date` DESC LIMIT ?, ?";

$dbh = new PDO('your_database_connection_string'); // replace with your database connection string

$productSearch = $dbh->prepare($sqlQuery);

// Bind parameters
foreach ($ids as $index => $id) {
    $productSearch->bindParam($index + 1, $id, PDO::PARAM_STR);
}
$start_record = $_GET['page'];
$limit = 50;
$productSearch->bindValue(count($ids) + 1, (int)$start_record, PDO::PARAM_INT);
$productSearch->bindValue(count($ids) + 2, (int)$limit, PDO::PARAM_INT);

// Execute the query
$productSearch->execute();