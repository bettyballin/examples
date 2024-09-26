<?php
$phrase = 'This is a test phrase';
$checksum = strtoupper(bin2hex(crc32($phrase)));
echo $checksum;
?>