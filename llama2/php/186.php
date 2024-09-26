<?php
$content = 'Your content here';
$actualDigest = base64_encode(hash('sha1', $content, true));
echo $actualDigest;
?>