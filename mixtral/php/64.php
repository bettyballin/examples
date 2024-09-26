<?php
$value = 'example_function(';
$value = preg_replace('/([A-Za-z0-9_\\x7f-\\xff]+)\\(/', '{$1}(', $value);
print($value);
?>