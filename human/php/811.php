function read_iv($fstream, $ivsize) {
    $IV = fread($fstream, $ivsize);
    return $IV;
}