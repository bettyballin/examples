<?php
// assuming $getregisterkey is a result of a mysql query
$getregisterkey = mysql_query("SELECT `key` FROM your_table");

while ($row = mysql_fetch_array($getregisterkey))
{
    $registerkey = mysql_real_escape_string($row['key']);
}
?>