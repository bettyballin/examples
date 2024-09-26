<?php
$safeFileName = basename($_FILES["file"]["name"]);
if (move_uploaded_file($_FILES["file"]["tmp_name"], "contact_load/" . $safeFileName)) {
    echo "File uploaded successfully!";
} else {
    echo "Error uploading file!";
}
?>