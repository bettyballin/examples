<?php

// ... existing code ...

if (isset($_SESSION['user_id'])) {
    $userId = $_SESSION['user_id'];
} else {
    die('You must be logged in to access this page.');
}

foreach ($_FILES['file']['name'] as $i => $filename) {
    $size = $_FILES['file']['size'][$i];
    $type = $_FILES['file']['type'][$i];
    if (($size < 10485760) && ($type === 'image/jpeg' || $type === 'image/png' || $type === 'image/gif')) {
        $extension = pathinfo($filename, PATHINFO_EXTENSION);
        $filename = "user_{$userId}_".uniqid() . '.' . $extension;
        // ...
    }
}

// ... existing code ...

?>