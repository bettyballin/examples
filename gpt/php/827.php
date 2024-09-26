
<?php
// Define the path to the file storage (outside of the web root)
define('FILE_STORAGE_PATH', '/path/to/secure/location/');

// Check if the 'file' GET parameter is present
if (isset($_GET['file'])) {
    $fileName = basename($_GET['file']); // Sanitize filename
    $filePath = FILE_STORAGE_PATH . $fileName;

    // Validate the file existence and permissions
    if (file_exists($filePath
