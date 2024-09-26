<?php
$userinput = "Test Input";
$serialized = serialize($userinput);
$unserialized = unserialize($serialized);

var_dump($unserialized);
?>