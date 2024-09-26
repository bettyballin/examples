<?php
$calories = 'some_value';
$colour = 'some_colour';

$dsn = 'sqlite:example.db';
$conn = new PDO($dsn);

$sql = "SELECT * FROM table WHERE calories = :calories AND colour = :colour";
$sth = $conn->prepare($sql);

$sth->execute(array(':calories' => $calories, ':colour' => $colour));

$result = $sth->fetchAll();
print_r($result);
?>