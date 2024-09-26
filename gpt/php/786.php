
function secure_rand($min, $max)
{
    $range = $max - $min;
    if ($range < 0) {
        throw new InvalidArgumentException('Invalid range.');
    }

    $log = log($range, 2);
    $bytes = (int) ($log / 8) + 1; // length in bytes
    $bits = (int) $log + 1; // length in bits
    $filter = (int) (1 << $bits) - 1; // set all lower bits to 1

    do {
        $rnd = hexdec(bin2hex(openssl_random_p
