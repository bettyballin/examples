<?php
$db = new PDO('sqlite::memory:');
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$unsafeValue = 'Hello, World!';

$preparedStatement = $db->prepare('CREATE TABLE table (column TEXT)');
$preparedStatement->execute();

$preparedStatement = $db->prepare('INSERT INTO table (column) VALUES (:column)');
$preparedStatement->execute(array('column' => $unsafeValue));

$result = $db->query('SELECT * FROM table');
print_r($result->fetchAll());
?>