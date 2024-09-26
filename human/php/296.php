<?php
$fd = fopen('/dev/random', 'r');
$bytes = fread($fd, 64);
fclose($fd);
print($bytes);
?>