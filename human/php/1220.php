<?php

$certificates = array(
    '-----BEGIN CERTIFICATE-----' . PHP_EOL .
    '(Your Primary SSL certificate: your_domain_name.crt)' . PHP_EOL .
    '-----END CERTIFICATE-----' . PHP_EOL,

    '-----BEGIN CERTIFICATE-----' . PHP_EOL .
    '(Your Intermediate certificate: DigiCertCA.crt)' . PHP_EOL .
    '-----END CERTIFICATE-----' . PHP_EOL,

    '-----BEGIN CERTIFICATE-----' . PHP_EOL .
    '(Your Root certificate: TrustedRoot.crt)' . PHP_EOL .
    '-----END CERTIFICATE-----' . PHP_EOL,
);

foreach ($certificates as $certificate) {
    echo $certificate . PHP_EOL;
}