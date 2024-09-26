<?php

class Request {
    private $form;

    public function __construct($form) {
        $this->form = $form;
    }

    public function get($key) {
        return $this->{$key};
    }
}

class Session {
    private $data;

    public function __construct() {
        $this->data = array();
    }

    public function set($key, $value) {
        $this->data[$key] = $value;
    }

    public function get($key) {
        return $this->data[$key];
    }
}

class Main {
    private $session;

    public function __construct(Session $session) {
        $this->session = $session;
    }

    public function get($key) {
        return $this->{$key};
    }

    public function main() {
        $formValues = array('field1' => 'value1', 'field2' => 'value2');
        $request = new Request((object)array('form' => $formValues));
        $session = $this->session;
        $formValues = $request->get('form');
        $session->set('formValues', $formValues);
        print_r($session->get('formValues'));
    }
}

$session = new Session();
$main = new Main($session);
$main->main();

?>