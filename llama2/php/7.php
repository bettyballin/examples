<?php
require_once 'vendor/autoload.php';
use League\MimeTypeDetection\MimeTypeDetector;

$detector = new MimeTypeDetector();
$mimeType = $detector->detect('ftp://user:password@example.com/path/to/file.txt');
echo "MIME Type: $mimeType\n";