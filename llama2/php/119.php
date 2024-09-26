<?php
function create_file($path, $filename, $content, $overwrite=false) {
  $res = false;
  if ($path == '/' || strpos($path, '..') !== false) return false;
  // Check for invalid file name
  if (preg_match('/^[a-z0-9\\.]+$/i', $filename)) {
    // Check for existing file
    if ($overwrite === true || !file_exists($path . '/' . $filename)) {
      // Open file
      if ($f = @fopen($path . '/' . $filename, 'w')) {
        fwrite($f, $content);
        fclose($f);
        $res = true;
      }
    }
  }
  return $res;
}

// Test the function
$path = './';
$filename = 'test.txt';
$content = 'Hello, World!';
$overwrite = true;

echo create_file($path, $filename, $content, $overwrite) ? 'File created successfully!' : 'Failed to create file!';
?>