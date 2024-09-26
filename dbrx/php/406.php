<?php
require 'vendor/autoload.php';

use MongoDB\Client;

$collection = (new Client)->yourDatabase->products;
$itemName = "exampleItem";
$itemQuantity = 10;

$result = $collection->insertOne([
    '_id' => 10,
    'item' => ['$literal' => $itemName],
    'qty' => intval($itemQuantity)
]);

var_dump($result);
?>