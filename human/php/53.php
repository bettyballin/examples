<?php
$Benutzer = 'your_username';
$PW = 'your_password';

$conn = pg_connect("host=localhost dbname=your_database user=your_database_user password=your_database_password");

if (!$conn) {
    die("Connection failed: " . pg_last_error());
}

$query = 'select * from Benutzer where Benutzername = $1 and Passwort = $2';
$params = array($Benutzer, md5($PW));
$results = pg_query_params($conn, $query, $params);

if (!$results) {
    die("Query failed: " . pg_last_error());
}

while ($row = pg_fetch_assoc($results)) {
    print_r($row);
}

pg_close($conn);
?>