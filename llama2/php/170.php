<?php

require_once 'vendor/autoload.php';

use OWASP\ESAPI\Encoder;

class CustomEncoder extends Encoder
{
    private $whitelist = [
        'b',
        'i',
        'u',
        's',
        'strike',
        'font',
        'span',
        'emphasis',
        'strong'
    ];

    public function encode($input)
    {
        $encoded = parent::encode($input);

        // Decode the whitelisted tags
        $encoded = str_replace(array_map('htmlspecialchars', $this->whitelist), array_map('rawurldecode', $this->whitelist), $encoded);

        return $encoded;
    }
}

// Usage example
$encoder = new CustomEncoder();
$input = '<b>Hello</b> <script>alert("XSS")</script>';
echo $encoder->encode($input);