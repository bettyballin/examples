<?php
$yourStringVariable = "Hello, 'world'!";
$result = htmlentities($yourStringVariable, ENT_QUOTES | ENT_HTML5, 'UTF-8');
print($result);
?>