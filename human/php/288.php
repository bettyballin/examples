<?php
$context = stream_context_create(array(
  'https' => array(
     'cafile' => '/path to file',
     'verify_peer' => true
  )));

$client = new SoapClient("https://localhost/index.php?wsdl",array(
  'login'=>'admin',
  'password'=>'passss',
  'stream_context'=> $context
));