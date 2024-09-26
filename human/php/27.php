<?php
// here is where
// you want your
// user authentication

$isAuthenticated = true; // replace with your authentication logic
$pathToFLV = 'path/to/your/video.flv'; // replace with your FLV file path

if ($isAuthenticated)
{
  header("Content-type: video/flv");
  echo file_get_contents($pathToFLV);
}
?>