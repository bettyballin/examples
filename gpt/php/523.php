
$base = gmp_init('your_base_number'); // Your base number as a GMP object
$exponent = gmp_init('your_large_exponent'); // Your large exponent as a GMP object
$modulus = gmp_init('your_modulus'); // Your modulus as a GMP object

$result = gmp_powm($base, $exponent, $modulus);

