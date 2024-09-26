<?php

// This is a string literal whitelist
$sortby = 'column_b'; // example value
switch ($sortby) {
    case 'column_b':
    case 'col_c':
        // If it literally matches here, it's safe to use
        break;
    default:
        $sortby = 'rowid';
}

// Only numeric characters will pass through this part of the code thanks to type casting
$start = 1; // example value
$howmany = 10; // example value
$start = (int) $start;
$howmany = (int) $howmany;
if ($start < 0) {
    $start = 0;
}
if ($howmany < 1) {
    $howmany = 1;
}

// The actual query execution
$db = new PDO('mysql:host=your_host;dbname=your_database', 'your_username', 'your_password'); // example database connection
$stmt = $db->prepare(
    "SELECT * FROM table WHERE col = ? ORDER BY {$sortby} ASC LIMIT {$start}, {$howmany}"
);
$stmt->execute(['value']);
$data = $stmt->fetchAll(PDO::FETCH_ASSOC);

print_r($data);