<?php

function has_access() {
    // logic to check access
    return false;
}

function abort($response) {
    http_response_code($response->getStatusCode());
    echo $response->getContent();
    exit;
}

function response() {
    return new Response();
}

class Response {
    private $view;
    private $statusCode;

    public function view($view, $data = [], $statusCode = 200) {
        $this->view = $view;
        $this->data = $data;
        $this->statusCode = $statusCode;
        return $this;
    }

    public function getStatusCode() {
        return $this->statusCode;
    }

    public function getContent() {
        extract($this->data);
        include 'resources/views/' . $this->view . '.php';
    }
}

class Exception {
    private $message;

    public function __construct($message) {
        $this->message = $message;
    }

    public function getMessage() {
        return $this->message;
    }
}

if(!has_access()){
    $exception = new Exception('Please contact support to gain access to this item.');
    abort(response()->view('errors.custom', ['exception' => $exception], 403));
}



<!-- resources/views/errors/custom.php -->
<h1>{{ $exception->getMessage() }}</h1>