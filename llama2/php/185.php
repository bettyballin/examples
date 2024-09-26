<?php

$xml = '<?xml version="1.0" encoding="UTF-8"?>' . "\n" . '<root>' . "\n" . '    <element attr="value">content</element>' . "\n" . '</root>';

$actualDigest = base64_encode(hash('sha1', $xml, true));

print($actualDigest);

?>