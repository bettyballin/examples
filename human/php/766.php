<?php
$root = '/home/user';
$imagesDir = $root . '/images';
$publicDir = $root . '/public';

if ($_SERVER['REQUEST_URI'] === '/images') {
    $filePath = $imagesDir . $_SERVER['REQUEST_URI'];
    if (file_exists($filePath)) {
        header('Content-Type: ' . mime_content_type($filePath));
        readfile($filePath);
        exit;
    }
}

$filePath = $publicDir . $_SERVER['REQUEST_URI'];
if (file_exists($filePath)) {
    header('Content-Type: ' . mime_content_type($filePath));
    readfile($filePath);
    exit;
}
?>