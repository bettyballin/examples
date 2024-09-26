<?php
$wsdl = 'http://example.com/service?wsdl'; // replace with your WSDL URL
$SoapClient = new SoapClient($wsdl, ['stream_context' => stream_context_create(['ssl' => ['verify_peer' => false]])]);