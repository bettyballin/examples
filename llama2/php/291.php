<?php

require 'vendor/autoload.php';

use Elasticsearch\ClientBuilder;

$client = ClientBuilder::create()->build();

$id = 'my_document_123';

if ($client->indices()->exists(['index' => 'my_index', 'id' => $id])) {
    // The ID is valid proceed with the query
    echo "The ID is valid.\n";
} else {
    // The ID is not valid return an error or log it
    echo "The ID is not valid.\n";
}

?>