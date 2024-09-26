<?php

// Configuration
const MAX_FILE_UPLOAD = 1024 * 1024 * 2; // 2MB

// Validate CSRF token
if (!isset($_POST['csrf_token']) || $_POST['csrf_token'] !== $_SESSION['csrf_token']) {
    die('Invalid CSRF token');
}

// Make sure there were no form errors
if ($_FILES['file']['error'] == UPLOAD_ERR_OK) {

    // Make sure the file size is good
    if ($_FILES['file']['size'] <= MAX_FILE_UPLOAD) {

        // Make sure we have a valid image type
        $type = exif_imagetype($_FILES['file']['tmp_name']);
        if ($type !== false) {

            // Make sure we check the type against a whitelist
            if (in_array(ltrim(image_type_to_extension($type), '.'), array('jpeg', 'jpg', 'png'))) {
                // Image is valid, you can now move it to a permanent location
                // using move_uploaded_file() and process it further
            } else {
                die('Invalid image type');
            }
        } else {
            die('Invalid image');
        }
    } else {
        die('File size exceeds maximum allowed');
    }
} else {
    die('Error uploading file');
}