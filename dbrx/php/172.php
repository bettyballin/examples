<?php
if(isset($_FILES)) {
    $key = array_key_first($_FILES);
    $fileName = $_FILES[$key]['name'];
    $fileExtension = strtolower(pathinfo($fileName, PATHINFO_EXTENSION));
    if ($fileExtension != 'jpg' && $fileExtension != 'jpeg') {
        echo "Error: Only .jpg and .jpeg files are allowed.";
    } else {
        echo "File uploaded successfully.";
    }
} else {
    echo "No file uploaded.";
}
?>