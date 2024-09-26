
$target_path = "uploads/";
$target_path = $target_path . basename($_FILES['uploadedfile']['name']); 

if(move_uploaded_file($_FILES['uploadedfile']['tmp_name'], $target_path)) {
    // Check the file size after it has been uploaded
    $actual_file_size = filesize($target_path);
    if ($actual_file_size <= $max_allowed_file_size) {
        //
