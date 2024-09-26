<?php
// DownloadHandler.php

$filePath = '/var/uploads/' . $_GET['filename'];

if (is_readable($filePath)) {
    header('Content-Type: application/octet-stream');
    header("Content-Transfer-Encoding: Binary");
    header("Content-disposition: attachment; filename=\"" . basename($filePath) . "\"");

    readfile($filePath);
} else {
    header("HTTP/1.0 404 Not Found");
    echo "File not found.";
    exit;
}
?>