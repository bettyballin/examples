<?php

class MultiContentSecurityPolicy {
    private $directives;

    public function __construct($directives) {
        $this->directives = $directives;
    }

    public function __toString() {
        return 'Content-Security-Policy: ' . implode('; ', $this->directives);
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

    public function addHeader($header) {
        $this->headers[] = (string)$header;
    }

    public function getHeaders() {
        return $this->headers;
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

$someDirectives = ['default-src \'self\'', 'script-src \'self\' https://example.com'];
$someOtherDirectives = ['style-src \'self\' https://example.com', 'img-src \'self\' https://example.com'];

$controller = new Controller();
$headers = $controller->getResponse()->getHeaders();
$headers->addHeader(new MultiContentSecurityPolicy($someDirectives));
$headers->addHeader(new MultiContentSecurityPolicy($someOtherDirectives));

print_r($headers->getHeaders());

?>