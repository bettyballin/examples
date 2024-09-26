<?php
session_start();
$userUploadDir = 'upload/' . $_SESSION['user_id'];

foreach (glob($userUploadDir . "/*") as $filename) {
    echo "<img src='$filename' alt='User Uploaded Image'>";
}

// Rest of the display script...
?>