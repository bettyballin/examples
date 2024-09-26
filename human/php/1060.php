<?php
class Input {
    function post($key, $xss_protection = FALSE) {
        if ($xss_protection) {
            return htmlentities($_POST[$key]);
        } else {
            return $_POST[$key];
        }
    }
}

class Main {
    function __construct() {
        $this->input = new Input();
    }

    function index() {
        $val = $this->input->post('some_data', TRUE);
        echo $val;
    }
}

$obj = new Main();
$obj->index();
?>