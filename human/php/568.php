<?php
error_reporting(E_ALL);
explode(":", $undefinedVariable); // will warn about undefined variable
@explode(":", $undefinedVariable); // will be silent

// It works also for array access etc.:
$foo = array('bar' => 5);
echo 10 * $foo['baz']; // warns
echo 10 * @$foo['baz']; // silent
?>