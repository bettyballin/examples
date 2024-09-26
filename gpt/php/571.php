
<?php
// Assuming you have some sort of user authentication and authorization in place
session_start();
$userHasAccess = checkUserAccess(); // Implement this function to check user permissions

if ($userHasAccess) {
    $filePath = '/path/to/your/non-public-directory/the-file.ext'; // Make sure this is outside of your document root
    $fileName = basename($filePath);

    // Check if the file exists and is readable
    if (file_exists($filePath) && is_readable($filePath)) {
        // Set the appropriate headers
        header('Content-Description: File Transfer');
        header('Content-Type: application/octet-stream'); // You may want to set a specific mime type based on the file
        header('Content-Disposition: attachment; filename="' . $fileName . '"');
        header('Expires: 0');
        header('Cache-Control: must-revalidate');
        header
