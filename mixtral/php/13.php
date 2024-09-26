<?php

$lengt = 20;
$character = 3;

for($i=0, $j=$lengt - (($character * ((int)floor(($lengt/$character))-1)));
    ($i < floor((float)$lengt/2));
     $i+=$character, $j -= $character){
    echo "i: $i, j: $j\n";
}

?>