<?php

$beerName = "Example Beer";
$brewery = "O'Flaherty's Brewery";

$beerName = addslashes($beerName);
$brewery = addslashes($brewery);
$brewery = str_replace('\'', '', $brewery);

print($beerName . "\n");
print($brewery . "\n");

?>