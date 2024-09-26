
<?php
// Define the base directory that users should be limited to
$baseDir = '/path/to/your/allowed/directory/';

// Sanitize the 'dir' parameter
$dir = isset($_GET['dir']) ? $_GET['dir'] : '';
$dir = str_replace('../', '', $dir); // Remove ../ to prevent directory traversal
$dir = rtrim($dir, '/') . '/'; // Ensure
