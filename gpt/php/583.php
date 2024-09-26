
$filename = $_GET["filename"];

if (strpos($filename, '..') !== false) {
    // Handle error:
