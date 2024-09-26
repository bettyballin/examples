<?php

$options = [
    'stream_context' => stream_context_create([
        'ssl' => [
            'cafile' => __DIR__ . '/cafile.pem',
        ],
    ]),
];

$wsdl = 'path_to_your_wsdl_file.wsdl'; // replace with your wsdl file path
$SoapClient = new SoapClient($wsdl, $options);

?>