<?php
function rotate_left($x, $c) {
    if($x < 0){
        return ($x << $c) | abs( ((pow(2, $c)) * -1) - ($x >> (32 - $c)));
    } else { 
        return ($x << $c) | ($x >> (32 - $c)) ;
    }
}

// Test the function
$x = -10;
$c = 2;
echo rotate_left($x, $c) . "\n";

$x = 10;
$c = 2;
echo rotate_left($x, $c) . "\n";
?>