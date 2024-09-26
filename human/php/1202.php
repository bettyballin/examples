<?php
$query = "SELECT 'a'='a'='a' AS col1, 'a'='a'='b' AS col2, 'a'='b'='a' AS col3, 'b'='a'='a' AS col4, 'b'='b'='a' AS col5";
$mysqli = new mysqli('localhost', 'username', 'password', 'database');
if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
}
$result = $mysqli->query($query);
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo $row["col1"]. " | " . $row["col2"]. " | " . $row["col3"]. " | " . $row["col4"]. " | " . $row["col5"]. "\n";
    }
} else {
    echo "0 results";
}
$mysqli->close();
?>