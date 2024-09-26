<?php
$collection = (new MongoDB\Client)->test->collection;
$cursor = $collection->find(["someProperty" => ['$exists' => true]]);
foreach ($cursor as $document) {
    var_dump($document);
}
?>