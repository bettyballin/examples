php
<?php
$beerName = "Example Beer";
$brewery = "O'Flaherty's Brewery";

$beerName = addslashes($beerName);
$brewery = addslashes($brewery);
$brewery = str_replace('\'', '', $brewery);

echo $beerName . "\n";
echo $brewery . "\n";
?>