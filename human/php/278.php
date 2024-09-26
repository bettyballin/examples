<?php
// Check permissions...
// If permissions OK:
$img = file_get_contents("/path/to/image.jpg");

// Send jpeg headers
header("Content-type: image/jpeg");
// Dump out the image data.
echo $img;
exit();
?>