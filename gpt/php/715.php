
$allowedExtensions = ['jpg', 'png', 'gif', 'pdf']; // etc.
$extension = strtolower(pathinfo($_FILES['userfile']['name'], PATHINFO_EXTENSION));
if (!in_array($extension, $allowedExtensions)) {
    die("Invalid file extension.");
}

