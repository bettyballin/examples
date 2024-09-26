<?php

$finfo = finfo_open(FILEINFO_MIME_TYPE);
$mime_type = finfo_file($finfo, $_FILES['file']['tmp_name']);

if ($mime_type == 'text/x-php' || $mime_type == 'application/x-httpd-php') {
    echo "File type not allowed.";
} else {
    if (move_uploaded_file($_FILES["file"]["tmp_name"], "/path/to/upload/directory/" . basename($_FILES["file"]["name"]))) {
        echo 'File uploaded';
    } else {
        echo 'Can not upload';
    }
}

finfo_close($finfo);

?>