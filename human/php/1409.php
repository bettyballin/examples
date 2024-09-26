<?php
// assume $db is a PDO instance
$query = "SELECT * FROM kategori WHERE true";

$params = [];
if (isset($query_research_str) && $query_research_str) {
    $query .= " AND user_name LIKE ?";
    $params[] = "%{$query_research_str}%";
}

if (!isset($order_by) || !isset($order_dir)) {
    $order_by = 'id'; // default column
    $order_dir = 'ASC'; // default direction
}

$query .= " ORDER BY `{$order_by}` {$order_dir}";

$s = $db->prepare($query);
$s->execute($params);

// fetch results
$results = $s->fetchAll();

// print results
print_r($results);
?>