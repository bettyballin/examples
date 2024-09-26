
<?php
// Connect to the database - replace with your own connection parameters
$link = mysql_connect('localhost', 'mysql_user', 'mysql_password');
if (!$link) {
    // Only show detailed error in production mode (adjust the condition accordingly)
    if (/* condition to check if in production mode */) {
        die('Could not connect: ' . mysql_error());
    } else {
        die('Could not connect to the database.');
    }
}

// Select the database
$db_selected = mysql_select_db('database_name', $link);
if (!$db_selected) {
    // Only show detailed error in production mode (adjust the condition accordingly)
    if (/* condition to check if in production mode */) {
        die ('Can\'t use database_name : ' . mysql_error());
    } else {
        die('Can\'t connect to the database.');
    }
}

// Escape the input data to help prevent SQL injection
$id = isset($_POST['id']) ? (int)$_POST['id'] : 0; // Cast to int to ensure it's a number
$name = isset($_POST['name']) ? mysql_real_escape_string($_POST['name'], $link) : '';

// Check if the
