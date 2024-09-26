
<?php

// Replace 'downloads.txt' with the path to your downloads count file
$countFile = 'downloads.txt';
$filePath = 'path/to/your/pdf_file.pdf'; // Replace with the actual PDF file path

// Function to get the file size in MB
function getFileSizeInMB($filePath) {
    return number_format(filesize($filePath) / 1048576, 2);
}

// Function to increment download count
function incrementDownloadCount($countFile) {
    if (file_exists($countFile)) {
        $count = (int)file_get_contents($countFile);
    } else {
        $count = 0;
    }
    $count++;
    file_put_contents($countFile, $count);
    return $count;
}

// Function to get current download count
function getDownloadCount($countFile) {
    return
