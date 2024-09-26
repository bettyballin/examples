#!/usr/bin/php
<?php

// Contains class DBConfig; database information.
require_once('../.dbcreds');                       

$dblink = mysql_connect(DBConfig::$host, DBConfig::$user, DBConfig::$pass);
mysql_select_db(DBConfig::$db);
//print_r($argv);

$sql = sprintf("SELECT url FROM GrabbedURLs WHERE %s LIKE '%s%%' LIMIT %s",
               mysql_real_escape_string($argv[1]),
               mysql_real_escape_string($argv[2]),
               mysql_real_escape_string($argv[3]));
echo "SQL: $sql\n";
$qq = mysql_query($sql);
while (($data = mysql_fetch_array($qq)))
{
        print_r($data);
}

?>