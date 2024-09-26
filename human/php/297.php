<?php
define('DBHOST', 'localhost');
define('DBPORT', '8080');
define('DBNAME', 'my_db_name');
define('DBUSER', 'root');
define('DBPASS', 'password');

$conn = new mysqli(DBHOST, DBUSER, DBPASS, DBNAME, DBPORT);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Your query here
$query = "SELECT * FROM your_table_name";

$result = $conn->query($query);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        print_r($row);
    }
} else {
    echo "0 results";
}

$conn->close();
?>