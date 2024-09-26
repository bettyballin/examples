<?php

$min = 1;
$max = 100;
$rand_in_range_min_to_max = 50;

$rand_min = (int)(($rand_in_range_min_to_max - $min) / ($max - $min) * mt_getrandmax());
$rand_max = (int)($rand_min + mt_getrandmax() / ($max - $min + 1));

// range whose values are mapped onto $rand_in_range_min_to_max
$range = range($rand_min, $rand_max);
foreach ($range as $rand) {
    assert($rand_in_range_min_to_max === (int)($min + ($max - $min) * ($rand/mt_getrandmax())));
}

print("Assertions passed!");

?>