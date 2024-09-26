function pad($pt) {
    $modulus = strlen($pt) % 8;
    $padlen = 8 - $modulus;
    for ($i = 0; $i < $padlen; $i++) {
        $pt .= chr($padlen);
    }
    return $pt;
}