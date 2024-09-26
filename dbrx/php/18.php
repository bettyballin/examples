<?php

// Check if user is logged in or has required permissions here...
// For demonstration purposes, we'll assume the user is logged in.
// In a real-world scenario, you'd replace this with actual authentication logic.
$isLoggedIn = true;

if (!$isLoggedIn) {
    header('HTTP/1.1 403 Forbidden');
    exit;
}

$filePath = '/path/to/protected_images/image.jpg'; // Replace with actual path of the file.
$fileSize = filesize($filePath);

if (!file_exists($filePath)) {
    header('HTTP/1.1 404 Not Found');
    exit;
}

header('Content-Type: image/jpeg');
header('Content-Length: ' . $fileSize);
header('Content-Disposition: inline; filename="image.jpg"');
header('Cache-Control: no-cache');
header('Pragma: no-cache');
header('Expires: 0');

readfile($filePath);  // Output data to browser

exit;
?>