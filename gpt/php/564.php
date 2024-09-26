
<?php
// Allowed referrer domain
$allowedReferrer = "https://yourmoodledomain.com";

// Extract the domain from the referrer
$referrer = isset($_SERVER['HTTP_REFERER']) ? parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) : '';

// Check if the referrer is the allowed domain
if ($referrer && strtolower($referrer) === strtolower(parse_url($allowedReferrer, PHP_URL_HOST))) {
    // Serve the file content
    // ...

    // Example: Read and return the contents of an HTML file
    $filePath = '/path/to/your/file.html';
    if (file_exists($filePath)) {
        header('Content-Type: text/html');
        readfile($filePath);
    } else {
