<?php
$wsdl = 'http://example.com/your/wsdl/url'; // replace with your WSDL URL
$context = stream_context_create([
    'ssl' => [
        'verify_peer'       => true,
        'verify_depth'      => 5,
        'cafile'            => '/path/to/ca-bundle.crt',
        'ciphers'           => 'HIGH:!SSLv2:!SSLv3:!TLSv1:@STRENGTH'
    ]
]);
$SoapClient = new SoapClient($wsdl, ['stream_context' => $context]);