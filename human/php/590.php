<?php
require ("configuration.php");

class DatabaseConnect
{
    function __construct()
    {
        mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die('Could not connect to MySQL server.');
        mysql_select_db(DB_DATABASE);
    }
}

// Create an instance of the class to make it executable
new DatabaseConnect();
?>