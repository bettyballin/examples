<?php
// Check if a file has been uploaded
if(isset($_FILES['file'])) {
    // Get the file type
    $type = exif_imagetype($_FILES['file']['tmp_name']);

    // give the file a unique name
    $hash = hash_file('sha1', $_FILES['file']['tmp_name']);
    $ext = image_type_to_extension($type);
    $fname = $hash . $ext;

    // Print the new filename
    echo $fname;
}
?>