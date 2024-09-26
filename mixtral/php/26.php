<?php

$filename = 'your_image_file.jpg'; // replace with your filename

$path = '/path_outside_webroot/' . $filename;
if (is_readable($path)) {
    header('Content-Type: image/jpeg');
    readfile($path);
} else {
    header('HTTP/1.1 404 Not Found');
    echo 'Image not found';
}
exit();

?>