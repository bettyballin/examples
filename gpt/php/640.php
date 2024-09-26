
<?php

// Define the maximum file size
$maxFileSize = 350000; // 350KB

// Check if the file size exceeds the limit
if ($_FILES['photo']['size'] > $maxFileSize) {
    echo "Your file is too large.";
    $ok = 0;
} else {
    // Proceed with the file upload process
    $ok = 1;
    $target_dir = "uploads/"; // Make sure this directory exists and is writable
    $target_file = $target_dir . basename($_FILES["photo"]["name"]);
    $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
    $newFileName = $target_dir . uniqid() . '.' . $imageFileType; // This will generate a unique file name

    // Check if image file is an actual image or fake image
