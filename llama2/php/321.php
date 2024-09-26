<?php
$dir = realpath(isset($_GET['dir']) ? $_GET['dir'] : './');
$files = scandir($dir);
echo json_encode($files);
?>