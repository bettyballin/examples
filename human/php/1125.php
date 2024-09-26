<?php
$filename="filetodownload.xyz";
$cf = realpath("/non-webaccessible-folder/".$filename);
$file=$cf;

header('Content-Disposition: attachment; filename="' . basename($cf) . '"');
header("Content-Length: " . filesize($cf));
header("Content-Type: application/octet-stream");
readfile(realpath($cf));
exit;
?>