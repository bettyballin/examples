<?php
$password = strip_tags(mysql_real_escape_string("**********"));
$usertable = strip_tags(mysql_real_escape_string("posts"));
$yourfield1 = strip_tags(mysql_real_escape_string("time"));
$yourfield2= strip_tags(mysql_real_escape_string("post"));

// Connection to database
$conn = mysql_connect("localhost", "username", $password);
if (!$conn) {
    die("Connection failed: " . mysql_error());
}

// Select database
$db_selected = mysql_select_db("your_database", $conn);
if (!$db_selected) {
    die("Can't use your_database : " . mysql_error());
}

// Query
$query = "SELECT $yourfield1, $yourfield2 FROM $usertable";
$result = mysql_query($query);
if (!$result) {
    die("Query failed: " . mysql_error());
}

// Print results
while ($row = mysql_fetch_assoc($result)) {
    echo $row[$yourfield1] . " - " . $row[$yourfield2] . "<br>";
}

// Close connection
mysql_close($conn);
?>