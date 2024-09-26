<?php
$data = 'Hello, World!';
$sealed_data = '';
$envelope_keys = array();
openssl_seal($data, $sealed_data, $envelope_keys, array('AES-256-CBC'), 'file://path/to/public.key');
?>