<?php
$file = $_FILES['image']; // Replace 'image' with your actual file input name
list($width, $height) = getimagesize($file['tmp_name']);
if ($width > 1000 || $height > 800) {
    // Handle large image here.
    echo "Image is too large.";
} else {
    echo "Image is within the allowed dimensions.";
}
?>