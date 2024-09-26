<?php
$md5 = bin2hex(random_bytes(10));
echo base64_encode($md5, BASE64_URL_SAFE);
?>