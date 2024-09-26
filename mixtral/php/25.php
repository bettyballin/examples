<?php
$file = $_FILES["file"];

// Check if file was successfully uploaded
if ($file['error'] === UPLOAD_ERR_OK) {
    // Get MIME type
    $finfo = finfo_open(FILEINFO_MIME_TYPE);
    $mimeType = finfo_file($finfo, $file['tmp_name']);

    // Validate that it's an image
    if (strpos($mimeType, 'image/') !== 0){
        die('Invalid file');
    }

    // Rename the uploaded file
    $newFileName = uniqid() . '-' . time();

    move_uploaded_file(
      $file["tmp_name"],
      "/path/to/" . $newFileName
    );

    finfo_close($finfo);
} else {
   die('Upload failed');
}
?>