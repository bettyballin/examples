<?php

$file = $_FILES['image'];

$imagick = new \Imagick();
$imagick->readImageBlob(file_get_contents($file['tmp_name']));
if ($imagick->getImageFormat() !== 'GIF') {
    // Handle non-GIF image here.
    echo "The uploaded image is not a GIF.";
} else {
    echo "The uploaded image is a GIF.";
}