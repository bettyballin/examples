<?php
$haystack = $_GET['file'];

if (strpos($haystack, '.mp3') !== false || strpos($haystack, '.wav') !== false) {
    echo "File extension found";
} else {
   die("Unauthorized");
}
?>