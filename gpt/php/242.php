
$mydata = $_GET['thefile'];

// Define the base directory
$baseDir = '/var/html/';

// Sanitize input to prevent directory traversal
$mydata = str_replace('..', '', $mydata);

// Realpath will return false if the file doesn't exist
$realPath = realpath($baseDir . $mydata);

// Check if the real path starts with the base directory
if ($realPath && strpos($realPath
