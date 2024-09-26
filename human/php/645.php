<?php
$foo = array('foo' => "Hello\0World");
$foo['foo']= str_replace(chr(0), '', $foo['foo']);
print($foo['foo']);
?>