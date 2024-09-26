<?php

$a = array(
    'a' => array(0),
    'b' => array(1, 0, 1),
    'c' => array(2, 1, 1, 0, 2),
    'd' => array(3, 2, 1, 2, 0, 3),
    'e' => array(4, 3, 2, 1, 3, 0, 4),
    'f' => array(4, 1, 3, 2, 1, 4),
    'g' => array(4, 2, 3, 3, 2, 4),
    'h' => array(4, 3, 3, 4),
    'i' => array(4, 4)
);

foreach ($a as $key => $value) {
    echo "$key > ";
    foreach ($value as $num) {
        echo str_pad($num, 2, '0', STR_PAD_LEFT) . ' ';
    }
    echo PHP_EOL;
}

?>