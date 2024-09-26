<?php
$allowedFiles = ['file1', 'file2'];

if (in_array(basename($_SERVER['REQUEST_URI']), $allowedFiles)) {
    include basename(__DIR__) . '/' . basename($_SERVER['REQUEST_URI']);
} else {
    http_response_code(404);
    echo 'Not Found';
    exit;
}