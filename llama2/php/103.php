<?php
$SQL = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');
$sanitizedArr = array(1, 2, 3); // example array of IDs
$stmt = $SQL->prepare("UPDATE `data_s` SET `set` = 1 WHERE `id` IN (".implode(',', array_fill(0, count($sanitizedArr), '?')).")");
$stmt->execute($sanitizedArr);
?>