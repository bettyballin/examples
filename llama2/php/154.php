<?php

class DatabaseConnect
{
    function __construct()
    {
        $conn = mysql_connect(getenv('DB_HOST'), getenv('DB_USER'), getenv('DB_PASSWORD')) or die('Could not connect to mysql server.');
        mysql_select_db('databasename', $conn);
    }
}

$db = new DatabaseConnect();

?>