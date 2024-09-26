<?php
$json = '{"name":"John","age":30,"city":"New York"}';

$jsonOptions = JSON_HEX_QUOT|JSON_HEX_TAG|JSON_HEX_AMP|JSON_HEX_APOS;

$jsonEncoded = json_encode(json_decode($json, true), $jsonOptions);

print($jsonEncoded);
?>