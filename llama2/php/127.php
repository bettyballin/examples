<?php

$allowedExtensions = array('jpg', 'jpeg', 'png', 'gif'); // add other accepted extensions as needed

// assuming you have a file input in your form
$file = $_FILES['file'];
$fileExtension = strtolower(end(explode('.', $file['name'])));

if (in_array($fileExtension, $allowedExtensions)) {
    // file is valid, proceed with processing
    echo "File is valid";
} else {
    // file is not valid, return error or take appropriate action
    echo "File is not valid";
}

?>