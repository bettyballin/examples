<?php
$base = gmp_init('2'); 
$exponent = gmp_init('3'); 

$result = gmp_powm($base, $exponent, '-1');
echo gmp_strval($result);
?>