<?php
class Uri {
    function segment($n) {
        $uri = $_SERVER['REQUEST_URI'];
        $segments = explode('/', $uri);
        return $segments[$n];
    }
}

class Test {
    public $uri;

    function __construct() {
        $this->uri = new Uri;
    }

    function user($user_id) {
        // dummy function
        return "User ID: $user_id";
    }

    function test() {
        $user_id = 123;
        return ($this->uri->segment(3)) ? $this->user($user_id) : FALSE;
    }
}

$obj = new Test;
echo $obj->test();
?>