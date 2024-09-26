$field = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

$diagonal = [];
for ($i = 0; $i < count($field); $i++) {
    for ($j = 0; $j + $i < count($field[$i]); $j++) {
        array_push($diagonal, $field[$i][$j]);
    }
}

print_r($diagonal);