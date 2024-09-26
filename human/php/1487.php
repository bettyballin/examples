<?php
class Request {
    public $server;

    function __construct() {
        $this->server = $_SERVER;
    }
}

class Response {
    function addHeader($header) {
        header($header);
    }
}

class Main {
    public $request;
    public $response;

    function __construct() {
        $this->request = new Request();
        $this->response = new Response();
    }

    function execute() {
        if(in_array($this->request->server['HTTP_ORIGIN'], [
            'http://xxx-domain.org',
            'https://example.org',
            'http://localhost:8888',
        ])) {
            $this->response->addHeader("Access-Control-Allow-Origin: {$this->request->server['HTTP_ORIGIN']}");
            $this->response->addHeader('Access-Control-Allow-Methods: GET, PUT, POST, DELETE, OPTIONS');
            $this->response->addHeader('Access-Control-Max-Age: 1000');
            $this->response->addHeader('Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With');
        }
    }
}

$main = new Main();
$main->execute();
?>