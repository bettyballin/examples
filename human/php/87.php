<?php
$image = $_GET['image'];
header("Content-Type: image/jpeg");
echo file_get_contents($image);
?>