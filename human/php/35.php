<?php
// server_root/web_root/protected-directory/access.php

$path = $_SERVER['DOCUMENT_ROOT'] . '/protected_root/foo/document.doc';
$deny = $_SERVER['DOCUMENT_ROOT'] . '/web_root/protected-directory/access-denied.html';

if (file_exists($path)) {
    $fileSize = filesize($path);
    $fileExt = pathinfo($path, PATHINFO_EXTENSION);
    $mimeType = getMimeType($fileExt);

    header('Content-Type: ' . $mimeType);
    header('Content-Length: ' . $fileSize);
    header('Content-Disposition: attachment; filename="document.doc"');

    readfile($path);
    exit;
} else {
    header('Location: ' . $deny);
    exit;
}

function getMimeType($ext) {
    switch ($ext) {
        case 'doc':
            return 'application/vnd.ms-word';
        default:
            return 'application/octet-stream';
    }
}


html
<!-- server_root/web_root/protected-directory/access-denied.html -->

<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <h1>Access Denied</h1>
    <p>You do not have permission to access the requested file.</p>
</body>
</html>