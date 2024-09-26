function pack($key) {
    $key = str_replace("-", "", $key);
    $raw = array();
    for ($i = 0; $i < strlen($key) / 2; $i++) {
        $raw[] = hexdec(substr($key, $i * 2, 2));
    }
    return $raw;
}