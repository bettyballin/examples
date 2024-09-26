<?php
session_start();
if (isset($_SESSION['user_id']) && !empty($_SESSION['user_id'])) {
    $filename = 'path/to/your/file.pdf';
    if (file_exists($filename)) {
        header('Content-type: application/pdf');
        header('Content-Disposition: inline; filename="' . basename($filename) . '"');
        header('Content-Transfer-Encoding: binary');
        header('Accept-Ranges: bytes');
        header('Content-Length: ' . filesize($filename));

        @readfile($filename);
        exit;
    } else {
        die('File not found.');
    }
} else {
    die('Access denied.');
}
?>