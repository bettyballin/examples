<?php

$allowedDomains = ['https://example.com', 'http://subdomain.example.org'];

if (in_array($_SERVER['HTTP_ORIGIN'], $allowedDomains)) {
    header('X-Permitted-Cross-Domain-Policies: master-only');
}

?>