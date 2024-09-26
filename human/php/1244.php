function createDesEdeKey($key) {
    if (strlen($key) < 24) {
        throw new Exception("InvalidKeyException: Key material is shorter than 24 bytes.");
    }
    $desEdeKey = substr($key, 0, 24);
    return $desEdeKey;
}