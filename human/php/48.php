<?php
$db = new mysqli("host","user","pw","database");
$stmt = $db->prepare("SELECT * FROM mytable where userid=? AND category=? ORDER BY id DESC");
$stmt->bind_param('ii', intval($_GET['userid']), intval($_GET['category']));
$stmt->execute();

$stmt->store_result();
$stmt->bind_result($column1, $column2, $column3);

while($stmt->fetch())
{
    echo "col1=$column1, col2=$column2, col3=$column3 \n";
}

$stmt->close();
$db->close();
?>