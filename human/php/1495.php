<?php

const FIREBASE_CONFIG = [
    'apiKey' => '<redacted>',
    'authDomain' => '<redacted>',
    'databaseURL' => '<redacted>',
    'projectId' => '<redacted>',
    'storageBucket' => '<redacted>',
    'messagingSenderId' => '<redacted>',
    'appId' => '<redacted>',
];

require __DIR__ . '/vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;

$firebase = (new Factory())
    ->withCredentials(ServiceAccount::fromJsonFile(__DIR__.'/path/to/serviceAccountKey.json'))
    ->withDatabaseUri(FIREBASE_CONFIG['databaseURL'])
    ->create();

$database = $firebase->getFirestore();

$collections = ['<redacted>', '<redacted>'];

foreach ($collections as $collection) {
    $documents = $database->collection($collection)->documents();
    echo "Data for $collection:\n";
    foreach ($documents as $document) {
        $data = $document->data();
        echo json_encode($data, JSON_PRETTY_PRINT) . "\n";
    }
}