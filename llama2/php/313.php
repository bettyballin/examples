<?php

class MergeableContentSecurityPolicy {
    private $policy;

    public function __construct(array $policy) {
        $this->policy = $policy;
    }

    public function __toString() {
        $policyString = '';
        foreach ($this->policy as $directive) {
            $policyString .= $directive . '; ';
        }
        return 'Content-Security-Policy: ' . trim($policyString) . "\n";
    }
}

class Response {
    private $headers;

    public function __construct() {
        $this->headers = new Headers();
    }

    public function getHeaders() {
        return $this->headers;
    }
}

class Headers {
    private $headers = [];

    public function add($header) {
        $this->headers[] = $header;
    }

    public function __toString() {
        $headersString = '';
        foreach ($this->headers as $header) {
            $headersString .= $header;
        }
        return $headersString;
    }
}

class Controller {
    private $response;

    public function __construct() {
        $this->response = new Response();
    }

    public function getResponse() {
        return $this->response;
    }
}

$controller = new Controller();
$headers = $controller->getResponse()->getHeaders();

// Add multiple policies
$headers->add(new MergeableContentSecurityPolicy([
    'script-src https://example.com',
    'style-src https://example.com'
]));

$headers->add(new MergeableContentSecurityPolicy([
    'script-src https://example.net',
    'font-src https://example.net'
]));

echo $headers;