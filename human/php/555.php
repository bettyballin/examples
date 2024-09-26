<?php
  $path = $_GET['path'];
  $file = 'img/users/pictures/'.$path;
  if (file_exists($file)) {
    header('Content-Type: '.mime_content_type($file));
    header('Content-Disposition: attachment; filename="'.basename($file).'"');
    header('Content-Length: '.filesize($file));
    readfile($file);
  } else {
    http_response_code(404);
    echo 'File not found';
  }
?>