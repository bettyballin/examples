php
<?php
$conn = mysql_connect("localhost", "username", "password");
mysql_select_db("database_name");

$getregisterkey = mysql_query("SELECT key FROM table_name");

while ($row = mysql_fetch_array($getregisterkey))
{
    $registerkey = mysql_real_escape_string($row['key']);
}
mysql_close($conn);
?>