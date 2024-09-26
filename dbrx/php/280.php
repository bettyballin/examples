<?php

$xml = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:v1="http://example.com/v1">
    <soapenv:Header/>
    <soapenv:Body>
        <v1:getInfoRequest>
            <!-- your data here -->
        </v1:getInfoRequest>
    </soapenv:Body>
</soapenv:Envelope>';

$dom = new DOMDocument();
$dom->loadXML($xml);

$bodyNode = $dom->getElementsByTagNameNS('http://schemas.xmlsoap.org/soap/envelope/', 'Body')->item(0);
$c14nXml = $bodyNode->C14N(true, false, null, ['http://www.w3.org/TR/xml-exc-c14n/#WithComments']);

$sha256Hash = hash('sha256', $c14nXml);

echo "SHA-256 Hash: {$sha256Hash}\n";

?>