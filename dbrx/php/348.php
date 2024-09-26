<?php

session_start();

// Get all files in the upload directory.
$files = glob('upload/*');

foreach ($files as $file) {
    if (is_file($file)) {
        // Extract the user ID from the filename.
        preg_match('/user_(\d+)_/', basename($file), $matches);
        $userId = intval($matches[1]);

        // Check whether this image belongs to the current user.
        if ($userId === $_SESSION['user_id']) {
            echo '<img src="' . htmlspecialchars($file) . '" alt="Image">';
            
            // Add a delete button for each of their images.
            echo '<form method="post" action=""><input type="submit" name="delete_' . basename($file) . '" value="Delete this image"></form>';
        }
    }
}

// Handle delete button submissions
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    foreach ($files as $file) {
        if (isset($_POST['delete_' . basename($file)])) {
            unlink($file);
            header('Refresh:0');
            exit;
        }
    }
}

?>