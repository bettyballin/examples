<?php

// Set error reporting level based on whether we're in production or not.
if (getenv('PRODUCTION')) {
    // In prod mode only show errors to admins and hide them from users.
    ini_set('display_errors', 0);
} else {
    // Not in a secure environment? Show all the things!
    error_reporting(E_ALL | E_STRICT);
}

// Check if id is numeric
if (!is_numeric($_POST['id'])) {
    trigger_error("Invalid ID: " . $_POST['id']);
    exit;
}

// Escape name to prevent SQL injection and XSS attacks.
$name = mysql_real_escape_string(strip_tags(trim($_POST['name'])));

// Connect to the database using a secure connection string
$db = @mysql_connect('localhost', 'username', 'password');
if (!$db) {
    trigger_error("Database connect error: " . mysql_error());
    exit;
}

// Select the correct database.
$selected = @mysql_select_db('my_database', $db);
if (!$selected) {
    trigger_error("Could not select DB: " . mysql_error($db));
    exit;
}

// Build and execute query
$query = sprintf(
    "UPDATE tablename SET name='%s' WHERE id=%d",
    $name,
    intval($_POST['id'])
);

$result = @mysql_query($query, $db);
if (!$result) {
    trigger_error("Query failed: " . mysql_error());
    exit;
}

// Output success message
echo "$name updated.";

?>