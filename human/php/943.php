<?php

$orders  = array("name","price","qty"); 
$key     = array_search($_GET['sort'],$orders); 
$orderby = $orders[$key] ?? $orders[0]; 
$query   = "SELECT * FROM `table` ORDER BY $orderby";

try {
    $pdo = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
    $stmt = $pdo->prepare($query);
    $stmt->execute();
    $result = $stmt->fetchAll();

    print_r($result);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
}

Replace `'your_database'`, `'your_username'`, and `'your_password'` with your actual database credentials. 

Please note that you should validate and sanitize `$_GET['sort']` before passing it to the query. The code above is still prone to SQL injection. A better approach would be to use a whitelist of allowed values. 

Also, this code assumes you are using MySQL. If you are using a different database system, you may need to adjust the connection string and query accordingly. 

**DO NOT USE THIS CODE IN PRODUCTION AS IS. IT IS FOR DEMONSTRATION PURPOSES ONLY.**