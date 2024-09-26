<?php
$id = '4f1b166d4931b15415000000';
$a = new MongoDB\BSON\ObjectID($id);
var_dump((string)$a === $id); // true

$id = 'foo';
$a = new MongoDB\BSON\ObjectID($id);
var_dump((string)$a === $id); // false