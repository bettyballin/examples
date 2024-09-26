<?php

use Zend\Http\Header\ContentSecurityPolicy;
use Zend\Http\Header\HeaderInterface;

$headers = $controller->getResponse()->getHeaders();

// Create and add the first CSP header
$csp1 = new ContentSecurityPolicy($someDirectives);
$headerName1 = 'Content-Security-Policy';

if ($csp1 instanceof HeaderInterface) {
    $headers->addHeaderLine(sprintf('%s: %s', $headerName1, $csp1->getFieldValue()));
} else {
    $headers->addHeaderLine(sprintf('%s: %s', $headerName1, (string)$csp1));
}

// Create and add the second CSP header
$csp2 = new ContentSecurityPolicy($someOtherDirectives);

if ($csp2 instanceof HeaderInterface) {
    $headers->addHeaderLine(sprintf('%s-1: %s', $headerName1, $csp2->getFieldValue()));
} else {
    $headers->addHeaderLine(sprintf('%s-1: %s', $headerName1, (string)$csp2));
}