<?php

class MyClass {
    public $my_login_helper;

    function _remap($method) {
        if (method_exists($this, $method) && $this->my_login_helper->is_logged_in()) {
            $this->$method();
        } else {
            redirect('/auth/');
        }
    }
}

function redirect($url) {
    header('Location: ' . $url);
    exit;
}

// Example usage
class MyLoginHelper {
    function is_logged_in() {
        return true; // Replace with actual login check
    }
}

$obj = new MyClass();
$obj->my_login_helper = new MyLoginHelper();
$obj->_remap('testMethod');

function testMethod() {
    echo 'Method called!';
}