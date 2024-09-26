<?php
$hash = $_GET['id'];
$info = get_image_metadata_from_database($hash); 
if ($info === false) {
    header('Content-type: image/jpeg');
    readfile('/path/to/image/with/errortext.jpg'); 
    exit;
}
header('Content-type: ' . $info['mime']);
readfile('/path/to/image/storage/' . $info['filename']);
exit;