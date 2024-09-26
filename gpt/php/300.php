
if ($_FILES['userfile']['error'] === UPLOAD_ERR_OK) {
    $file_tmp = $_FILES['userfile']['tmp_name'];
    $image_type = exif_imagetype($file_tmp);

    if ($image_type !== false) {
        // This is indeed an image, and $image_type holds one of the IMAGETYPE_XXX constants
        // Proceed with further file checks (size, dimensions, etc.) and then with the upload
    } else {
        // File is not a valid image
