<?php
$x = 40;
$string = "inputstring";
$boolResult = (preg_match('/^[0-9a-f]{' . $x . '}$/i', $string) === 1) ? true : false;

print($boolResult ? 'True' : 'False');
?>