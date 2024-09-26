<?php
$encryptedBuffer = 'your_encrypted_buffer_string';
$progress = 0;
$chunkSize = 10;

$encryptedChunk = substr($encryptedBuffer, $progress, $chunkSize);

print($encryptedChunk);
?>