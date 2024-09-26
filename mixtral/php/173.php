<?php
$allowedExtensions = ['csv', 'txt'];
$safeFileName = 'example.txt'; // replace with your file name
$fileExtension = strtolower(pathinfo($safeFileName, PATHINFO_EXTENSION));
if (!in_array($fileExtension, $allowedExtensions)) {
    echo "Error: File extension not allowed.";
} else {
    echo "File extension is allowed.";
}
?>