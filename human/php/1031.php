<?php
$block = 16; // Define block size
$str = "Hello, World!"; // Define input string

$pad = $block - (strlen($str) % $block);
$str .= str_repeat(chr($pad), $pad);

print($str);
?>