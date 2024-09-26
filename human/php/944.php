<?php
if(isset($_FILES['uploadfile'])) {
    $x = getimagesize($_FILES['uploadfile']['tmp_name']);
    if (isset($x)) {
        if($x['mime'] != 'image/gif' && $x['mime'] != 'image/jpeg') {
            echo 'Not a valid GIF or JPEG';
            exit(0);
        } else {
            echo 'Valid GIF or JPEG';
        }
    } else {
        echo 'Unable to get image size';
    }
} else {
    echo 'No file uploaded';
}
?>
<form action="" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadfile">
    <input type="submit" value="Upload">
</form>