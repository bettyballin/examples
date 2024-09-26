<?php
$random_binary = random_bytes(32);
$base64_encoded_string = base64_encode($random_binary);
print($base64_encoded_string);
?>