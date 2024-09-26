
// serve_document.php
<?php
// Check if the HTTP_REFERER is set and contains your domain and the index.php path
$referrer = $_SERVER['HTTP_REFERER'] ?? '';
$allowed_referrer = 'http://www.domain.com/index.php'; // Adjust if necessary

if (strpos($referrer, $allowed_referrer) !== false) {
    // Correct referrer: Serve the file
    $
