<?php
function rotate_left($x, $c) {
  return ($x < 0) ? (($x << $c) | abs( ((pow(2, $c)) * -1) - ($x >> (32 - $c)))) : (($x << $c) | ($x >> (32 - $c)));
}

// Test the function
$x = -10;
$c = 2;
echo rotate_left($x, $c) . "\n";

$x = 10;
$c = 2;
echo rotate_left($x, $c) . "\n";
?>