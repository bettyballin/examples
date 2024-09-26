$finfo = finfo_open(FILEINFO_MIME_TYPE);
$mime_type = finfo_file($finfo, $_FILES['userfile']['tmp_name']);
finfo_close($finfo);

// check if mime type is allowed
if (in_array($mime_type, ['image/jpeg', 'image/png'])) {
    // file is safe to upload
} else {
    die('Invalid file format');
}