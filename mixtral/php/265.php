<?php
$filename = $_GET['file'];

// Validate filename
if (!preg_match('/^[a-zA-Z0-9._]+$/', $filename)) {
    die('Invalid file name');
}

$downloadPath = '/var/www/downloads/' . basename($filename);

if (file_exists($downloadPath) && is_readable($downloadPath)) {

  // Set headers
  header("Content-Type: application/octet-stream");
  header('Content-Disposition: attachment; filename="' . $filename . '"');

  readfile($downloadPath);

} else {

    die('File not found or unreadable.');

}
?>