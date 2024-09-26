<?php

$file = '/path/to/file.pdf';

if (!is_file($file)) {
    http_response_code(404);
    echo 'File not found.';
    exit;
}

$filename = basename($file);
$mimetype = mime_content_type($file);

header('Content-Type: ' . $mimetype);
header('Content-Length: ' . filesize($file));
header('Content-Disposition: attachment; filename="' . $filename . '"');
readfile($file);

?>