<?php
// Establish a connection to the database
$conn = mysql_connect('localhost', 'username', 'password');
mysql_select_db('database_name', $conn);

// Execute a query
$result = mysql_query('SELECT * FROM table_name', $conn);

// Check if a row is fetched
if ($row = mysql_fetch_array($result)) {
    // row fetched, continue execution
    echo 'Row fetched successfully';
} else {
    // no row fetched, abort
    echo 'No row fetched, aborting';
    exit;
}

// Close the connection
mysql_close($conn);
?>