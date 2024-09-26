<?php
header('Content-type: application/octet-stream');
header('Content-disposition: attachment; filename=usersuppliedname.txt');
header("Content-Length: " . filesize('../safefiles/1.txt'));
header("Content-Transfer-Encoding:  binary");
readfile('../safefiles/1.txt');
exit;
?>