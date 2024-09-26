<?php
class Signature {
    public function hash() {
        $key = "hello";
        $msg = mb_convert_encoding("Hello", 'UTF-8', 'ASCII');
        return hash_hmac('sha256', $msg, $key, true);
    }

    public function hmacHex($msg) {
        $key = "hello";
        return hash_hmac('sha256', mb_convert_encoding($msg, 'UTF-8', 'ASCII'), $key, false);
    }
}

// example usage
$signature = new Signature();
echo $signature->hash();
echo $signature->hmacHex("Hello");
?>