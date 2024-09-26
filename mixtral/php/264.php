<?php
$field = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

$n = count($field);
for ($i = 0; $i < 2 * $n - 1; $i++) {
    for ($j = $i, $k = 0; $j >= 0 && $k <= min($i, $n - 1); $j--, $k++) {
        echo isset($field[$j][$k]) ? $field[$j][$k] : ' ';
    }
    echo PHP_EOL;
}