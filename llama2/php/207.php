<?php
$imagePath = isset($_GET['image']) ? $_GET['image'] : '';
$imageFiles = glob($imagePath);
$imageFile = reset($imageFiles);

// Example usage:
echo $imageFile;
?>