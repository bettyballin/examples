<?php
if (isset($_FILES['file'])) {
    $upload_path = '/path/to/private/folder';
    $fname = basename($_FILES['file']['name']);
    if (move_uploaded_file($_FILES['file']['tmp_name'], "$upload_path/$fname")) {
        echo "File uploaded successfully.";
    } else {
        echo "Failed to upload file.";
    }
} else {
    echo "No file selected.";
}
?>
<form action="" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Upload">
</form>