function decrypt($key, $data) {
    // Generate a 24 bytes long Triple DES (3DES) Key
    $hash = sha1(utf8_encode($key), true);

    if (strlen($hash) > 24) {
        throw new Exception("Key size is too large");
    }

    // ... rest of your code
}