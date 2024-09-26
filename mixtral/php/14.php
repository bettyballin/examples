<?php
$position = 0;
$lengt = 100;
$block = 10;
$characters = 5;
$i = 0;
$jposition = 0;

for (; $position < ($lengt - ((int)(floor(($lengt/$block))-1)*$block)); 
    ++$i, $jposition += $characters) {
    echo "Position: $position, i: $i, jposition: $jposition\n";
    $position++;
}
?>