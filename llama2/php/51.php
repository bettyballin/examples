<?php
$phrase = 'This is a test phrase';
$hash = hash('crc32', $phrase);
echo $hash;
?>