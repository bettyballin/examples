<?php

function gmp_pow_large(GMP $base, string $exponent): GMP {
    if (gmp_cmp($exponent, '0') === 0) {
        return gmp_init('1');
    }

    $result = gmp_init('1');
    $base = gmp_init($base);

    for ($i = strlen($exponent); $i > 0; --$i) {
        $bit = substr($exponent, -1 * $i, 1);

        if (gmp_cmp(gmp_mod($base, '2'), '1') === 0 && gmp_cmp($result, '1') !== 0) {
            // If the base is odd and result is not one
            // we need to multiply by two before squaring.
            $result = gmp_mul($result, $result);
        }

        if (gmp_cmp($bit, '1') === 0) {
            $result = gmp_mul($result, $base);
        }

        $base = gmp_mul($base, $base);
    }

    return $result;
}

// Test the function
$base = gmp_init('2');
$exponent = '10';
echo gmp_strval(gmp_pow_large($base, $exponent));

?>