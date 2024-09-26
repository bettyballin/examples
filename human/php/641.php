<?php
$min = 1;
$max = 100;
$rand = mt_rand();

$rand_in_range_min_to_max = (int)($min + ($max - $min) * ($rand/mt_getrandmax()));

echo $rand_in_range_min_to_max;
?>