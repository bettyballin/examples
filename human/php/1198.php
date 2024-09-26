<?php
$db = new mysqli('localhost', 'username', 'password', 'database');

$sql = "SELECT '\"foo\"' = '\"\"foo\"\"', '\"foo\"' = '\"\\\"foo\\\"', 'foo' = '\"\"foo\"\"'";
$result = $db->query($sql);

while ($row = $result->fetch_assoc()) {
    print_r($row);
}
?>