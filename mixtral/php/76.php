<?php

$request = new DOMDocument();
$request->loadXML('<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <example>Some example content</example>
    </soap:Body>
</soap:Envelope>');

$ns = 'http://schemas.xmlsoap.org/soap/envelope/';

$body = $request->getElementsByTagNameNS($ns, 'Body')->item(0);

foreach ($body->childNodes as $node) {
    if (XML_ELEMENT_NODE === $node->nodeType && !empty($node->textContent)) {
        // Canonicalize the XML
        $content = $node->C14N();

        // Calculate SHA-1 hash and encode to Base64
        $digestValue = base64_encode(hash('sha1', $content, true));

        break;
    }
}

print $digestValue;

?>