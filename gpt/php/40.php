
<?php
// Define the path to the image storage
define('IMAGE_STORAGE_PATH', '../userimages/');

// Make sure there's a filename and that the filename is safe
if (isset($_GET['filename']) && preg_match('/^[a-zA-Z0-9_-]+\.jpg$/', $_GET['filename'])) {
    $file = IMAGE_STORAGE_PATH . $_GET['filename'];

    // Check if the file exists
   
