<?php
$field = 'your_field_name';
$value = 'your_value';

$conn = mysqli_connect("localhost", "username", "password", "database");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "SELECT number FROM PhoneNumbers " .
       "WHERE " . mysqli_real_escape_string($conn, $field) . " = '" . mysqli_real_escape_string($conn, $value) . "'";

$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
        echo "Number: " . $row["number"]. "<br>";
    }
} else {
    echo "0 results";
}

mysqli_close($conn);
?>