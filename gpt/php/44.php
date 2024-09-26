
<?php

$track = "sometrack.mp3";

if (file_exists($track)) {
    // Fix the Content-Disposition header
    header('Content-Type: audio/mpeg');
    header('Content-Length: ' . filesize($track));
    header('Content-Disposition: attachment; filename="' . basename($track) . '"'); // Enclose the filename in quotes
    header('X-Pad: avoid browser bug');
    header('Cache-Control: no-cache');
    // Use readfile() instead of file_get_contents() and print
    readfile($track);
    exit;
} else {
    echo "No file";
}

