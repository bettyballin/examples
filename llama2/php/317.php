<?php
$db = new PDO('mysql:host=your_host;dbname=your_database', 'your_username', 'your_password');

$query_research_str = '%your_search_string%'; // replace with your search string

$query = "SELECT * FROM users WHERE user_name LIKE :username";
$stmt = $db->prepare($query);
$stmt->bindParam(':username', $query_research_str, PDO::PARAM_STR);
$stmt->execute();

$results = $stmt->fetchAll(PDO::FETCH_ASSOC);
print_r($results);
?>