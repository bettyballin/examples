<?php
require 'vendor/autoload.php';

use Ramsey\Uuid\Uuid;

$url = "https://example.com"; // Replace with your URL

$uuid = Uuid::uuid4(); // Get a UUID
$urlHash = hash('sha256', $url); // Hash the URL
$encodedUrl = strtoupper(bin2hex($uuid->getBytes() . $urlHash)); // Encode the UUID and hash

$file = "$encodedUrl.html"; // Use the encoded URL as the file name

echo $file;
?>