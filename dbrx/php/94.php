<?php
$allowed_extensions = ['jpg', 'jpeg', 'png'];
$file_extension = strtolower(pathinfo($_FILES['file']['name'], PATHINFO_EXTENSION));

if (!in_array($file_extension, $allowed_extensions)) {
    echo "Error: File extension not allowed.";
    exit;
}

$finfo = finfo_open(FILEINFO_MIME_TYPE);
$mimetype = finfo_file($finfo, $_FILES['file']['tmp_name']);
finfo_close($finfo);

$allowed_mimetypes = ['image/jpeg', 'image/png'];

if (!in_array($mimetype, $allowed_mimetypes)) {
    echo "Error: File mimetype not allowed.";
    exit;
}

echo "File uploaded successfully.";
?>