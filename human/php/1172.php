<?php
header('HTTP/1.1 302 Found');
header('Location: https://example-bucket.s3...');
header('Cache-Control: private, no-cache, no-store');
exit;
?>