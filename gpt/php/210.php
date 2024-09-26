
$allowed_extensions = ['pdf', 'doc', 'docx'];

$ext = pathinfo($file, PATHINFO_EXTENSION);
if (!in_array(strtolower($ext), $allowed_extensions)) {
    exit('Invalid file type.');
}

