<?php
class Obj {
    function method_name($matches) {
        return $matches[0];
    }
}

$obj = new Obj;
$rx = '/regex_pattern/';
$content = 'Hello, world!';
$content = preg_replace_callback($rx, array($obj, 'method_name'), $content);
print($content);
?>