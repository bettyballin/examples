<?php
$url = 'http://127.0.0.1/test.php//?&mod=server';

$urlParts = parse_url($url);
$path = rtrim($urlParts['path'], '/');

$newUrl = $urlParts['scheme'] . '://' . $urlParts['host'] . $path . '/' . $urlParts['query'];

print($newUrl);
?>