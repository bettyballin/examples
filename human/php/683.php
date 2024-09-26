<?php
$expr = "your_expression_here";
while(strpos($expr, '()') !== false)
  $expr = str_replace('()', '', $expr);

$expr = trim($expr, '+-/*');
print($expr);
?>