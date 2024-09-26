<?php

$decodedImage = filter_input(INPUT_POST, 'canvas', FILTER_DEFAULT, FILTER_FLAG_STRIP_LOW | FILTER_FLAG_STRIP_HIGH);
if (!$decodedImage) {
    echo "Error: Invalid image data.";
    exit;
}

$tempFilePath = tempnam(sys_get_temp_dir(), 'canvas-web');
file_put_contents($tempFilePath, $decodedImage);

$imageTypeValidation = exif_imagetype($tempFilePath);
if ($imageTypeValidation !== IMAGETYPE_JPEG && $imageTypeValidation !== IMAGETYPE_PNG) {
    echo "Error: Invalid image type.";
    unlink($tempFilePath);  // Delete the temporary file
    exit;
}

// ... rest of your code ...

unlink($tempFilePath);  // Delete the temporary file

?>