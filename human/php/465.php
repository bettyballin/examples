<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

if ($mysqli->connect_errno) {
    die("Connect failed: " . $mysqli->connect_error);
}

$now = date('Y-m-d H:i:s');
$interval = new DateTime('now');
$interval->modify('-5 minutes');

$query = "SELECT ip, COUNT(timestamps) as count 
          FROM table_name 
          WHERE timestamp >= '$interval->format('Y-m-d H:i:s')' 
          GROUP BY ip";

$result = $mysqli->query($query);

while($row = $result->fetch_assoc()) {
    echo "IP: " . $row["ip"]. " Count: " . $row["count"]. "\n";
}

$mysqli->close();
?>