<?php
$ctx = stream_context_create(['ssl' => [
    'verify_peer' => true,
    'cafile' => 'd:/sandbox/mycerts.pem',
    'CN_match' => 'ftp-12345678.mywebhoster.com'
]]);