<?php
$image = $_GET['image'];
$ext = pathinfo($image, PATHINFO_EXTENSION);
switch ($ext) {
  case 'png':
  case 'jpg':
  case 'gif':
    header('Content-Type: image/' . $ext);
    readfile('path_to_your_images/' . $image);
    break;
  default:
    header('HTTP/1.0 404 Not Found');
}
?>