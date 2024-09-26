
<?php
$xmlString = <<<XML
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Header/>
    <Body>
        <!-- Your Body Content Here -->
    </Body>
</Envelope>
XML;

// Load the string into a DOMDocument object
$dom = new DOMDocument();
$dom->loadXML($xmlString);

// Find the element you want to sign, e.g., the SOAP body
$xpath = new DOMXPath($dom);
$xpath->registerNamespace('soap', 'http://schemas.xmlsoap.org/soap/envelope/');
$bodyNodeList = $xpath->query('/soap:Envelope/soap:Body');

// Perform the exclusive Canonicalization
if ($bodyNodeList->length >
