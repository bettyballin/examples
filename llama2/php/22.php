<?php

function validateUploadedFile($file) {
    $allowedExtensions = array('jpg', 'jpeg', 'png');
    $fileExtension = pathinfo($file['name'], PATHINFO_EXTENSION);

    if (in_array($fileExtension, $allowedExtensions)) {
        return true;
    }

    return false;
}

if (isset($_FILES['upload'])) {
    if (!validateUploadedFile($_FILES['upload'])) {
        echo "Invalid file upload";
    } else {
        echo "Valid file upload";
    }
} else {
    echo "No file uploaded";
}