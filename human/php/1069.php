<?php
class MyClass {
    function sanitizeInput($input) {
        return trim(strip_tags($input));
    }

    function getParam($key, $default=null) {
        return isset($_REQUEST[$key])? $this->sanitizeInput($_REQUEST[$key]) : $default;
    }
}

$obj = new MyClass();
echo $obj->getParam('test', 'default value');
?>