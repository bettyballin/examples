
<?php
session_start();

// Check if the user is authenticated and authorized to view the image
if (isset($_SESSION['user_id']) && userHasAccessToImage($_SESSION['user_id'], $_GET['image_id'])) {
    $imageFilePath = '/var/private_images/' . $_GET['image_id'];

    // Serve the image content
    header('Content-Type: image/jpeg'); // Adjust the content
