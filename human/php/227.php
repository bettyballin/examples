<?php
$dsn = 'mysql:host=localhost;dbname=your_database'; // replace with your database connection
$pdo = new PDO($dsn);

$column = 'url';
$value = 'http://www.stackoverflow.com/';
$limit = 1;

$validColumns = array('url', 'last_fetched');

if (!in_array($column, $validColumns)) {
    $column = 'id';
}

$statement = $pdo->prepare('SELECT url FROM GrabbedURLs ' .
                           'WHERE ' . $column . '=? ' .
                           'LIMIT ' . intval($limit));
$statement->execute(array($value));
while (($data = $statement->fetch())) {
    // do something with $data
    print_r($data);
}
?>