<?php

class My_SoapClient extends SoapClient
{
    protected function __doRequest($request, $location, $action, $version) 
    {
        $domRequest = new DOMDocument();
        $domRequest->loadXML($request);

        $xp = new DOMXPath($domRequest);
        $xp->registerNamespace('s', 'http://www.w3.org/2003/05/soap-envelope');
        $header = $xp->query('/s:Envelope/s:Header')->item(0);

        $usernameToken = $domRequest->createElementNS('http://schemas.xmlsoap.org/ws/2002/07/secext', 'wsse:UsernameToken');
        $username = $domRequest->createElementNS('http://schemas.xmlsoap.org/ws/2002/07/secext', 'wsse:Username', 'userid');
        $password = $domRequest->createElementNS('http://schemas.xmlsoap.org/ws/2002/07/secext', 'wsse:Password', 'password');
        $usernameToken->appendChild($username);
        $usernameToken->appendChild($password);
        $header->appendChild($usernameToken);

        $request = $domRequest->saveXML();
        return parent::__doRequest($request, $location, $action, $version);
    }
}

// Example usage:
$url = 'http://example.com/soap/service';
$client = new My_SoapClient($url);
$response = $client->__soapCall('someMethod', array('someParam'));
print_r($response);