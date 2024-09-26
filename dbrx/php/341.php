<?php

// Check if a valid filename is provided in the query string
$filename = isset($_GET['file']) ? basename($_GET['file']) : null;
if (empty($filename)) {
    die('No file specified.');
}

// Define allowed referrers and files here
$allowedReferrers = ['http://www.domain.com/', 'https://www.domain.com/'];
$allowedFiles     = ['document.pdf'];

// Check if the request is coming from an authorized page
if (!in_array($_SERVER['HTTP_REFERER'], $allowedReferrers)) {
    die('Unauthorized access.');
}

// Check if the requested file exists and it's allowed to be downloaded
if (file_exists($filename) && in_array(basename($filename), $allowedFiles)) {
    header('Content-Type: application/pdf');
    readfile($filename);
} else {
    die('File not found or unauthorized download attempt.');
}