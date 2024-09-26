
$allowed_extensions = ['jpg', 'png', 'txt', 'pdf']; // Add more allowed extensions as needed
$uploaded_file_extension = pathinfo($_FILES['uploaded_file']['name'], PATHINFO_EXTENSION);

if (!in_array(strtolower($uploaded_file_extension), $allowed_extensions)) {
    die("This file type is not allowed.");
}

