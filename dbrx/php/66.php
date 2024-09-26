<?php
require_once 'HTMLPurifier.auto.php';

$config = HTMLPurifier_Config::createDefault();
$purifier = new HTMLPurifier($config);

$input = '<b>Hello World!</b>';
$output = $purifier->purify($input);

echo $output;
?>