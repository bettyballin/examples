<?php
$db = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');
$stmt = $db->query("SELECT 'a' = 'a' = 'a'");
$result = $stmt->fetchColumn();
print($result);
?>