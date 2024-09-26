<?php
$stmt = $mysqli->prepare("SELECT * FROM your_table");
$stmt->execute();
$stmt->store_result();

$resultrow = array();
$stmt->bind_result($resultrow);

while($stmt->fetch())
{
    print_r($resultrow);
}
?>