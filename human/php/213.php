<?php
$file = 'path/to/your/file.txt';
$fileSize = filesize($file);

header("Content-type: application/octet-stream");
header("Content-length: $fileSize");
header("Content-Disposition: attachment; filename=\"$file\"");

readfile($file);
exit;
?>