
<?php
$allowed_referer = 'http://example.com/myform.html';

// Check if the Referer header is set and matches the allowed referer
if (isset($_SERVER['HTTP_REFERER']) && parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) == parse_url($allowed_referer, PHP_URL_HOST)) {
    // Process the form data
    // ...
} else {
    // Forbidden access - you can redirect, throw an error, or ignore the submission
    header('HTTP/1.0 403 Forbidden');
    echo "You are not allowed to access this page directly.";
    exit;
}
?>

