
<?php
// Check user permissions here
// ...

// Assume you've verified that the image can be served to this user
$imageId = $_GET['id']; // or use a safer method to get the image ID
$imagePath = "/path/to/protected/images/{$imageId}.jpg";

// Set the content-type header to the appropriate image type
header('Content-Type: image/jpeg');

// Read and output the image content
readfile($imagePath);

