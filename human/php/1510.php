<?php

$itemName = "Item 1";
$itemQuantity = 10;

$jsonString = '{"_id": 10, "item": "'.$itemName.'", "qty": '.$itemQuantity.'}';

$jsonObject = json_decode($jsonString, true);

$connection = new MongoClient();
$db = $connection->selectDB("database_name");
$collection = $db->selectCollection("products");

$collection->insertOne($jsonObject);

?>