
$finfo = finfo_open(FILEINFO_MIME_TYPE);
$mimeType = finfo_file($finfo, $_FILES['userfile']['tmp_name']);
finfo_close($finfo);

$allowedMimeTypes = ['image/jpeg', 'image/png', 'image/gif', 'application/pdf']; // etc.
if (!in_array($mimeType, $allowedMimeTypes)) {
    die("Invalid file type.");
