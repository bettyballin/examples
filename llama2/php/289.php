<?php

$body = <<<EOF
<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">
    <soapenv:Body>
        <m:GetLastTradePriceResponse xmlns:m=\"http://www.example.com\">
            <m:return>
                <m:lastTradePrice>123456789</m:lastTradePrice>
            </m:return>
        </m:GetLastTradePriceResponse>
    </soapenv:Body>
</soapenv:Envelope>
EOF;

$writer = new XMLWriter();
$writer->openMemory();
$writer->setIndent(true);
$writer->startDocument('1.0', 'UTF-8');
$writer->writeDTD('http://schemas.xmlsoap.org/soap/envelope/', 'SOAP Envelope');
$writer->startElementNS(null, 'Envelope', 'http://schemas.xmlsoap.org/soap/envelope/');
$writer->writeAttributeNS('xsi', 'xmlns:xsi', null, 'http://www.w3.org/2001/XMLSchema-instance');

$output = $writer->outputMemory();
print($output);

?>